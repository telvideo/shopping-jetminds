package com.example.network.di

import com.example.network.ApiService
import com.example.network.BuildConfig
import com.example.network.utils.Constants
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.security.KeyStore
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManagerFactory
import javax.net.ssl.X509TrustManager

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @[Provides Singleton]
    fun providesAuthQueryAppenderInterceptor(): Interceptor =
        Interceptor { chain ->
            val requestBuilder = chain.request().newBuilder()

            val url = chain.request().url
            val keyBuilder = url.newBuilder()
            if (url.queryParameter("consumer_key") == null) {
                keyBuilder.addQueryParameter(name = "consumer_key", value = BuildConfig.CONSUMER_KEY)
                keyBuilder.addQueryParameter(name = "consumer_secret", value = BuildConfig.CONSUMER_SECRET)
            }
            chain.proceed(
                requestBuilder
                    .url(keyBuilder.build())
                    .build()
            )
        }

    @[Provides Singleton]
    fun providesLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @[Provides Singleton]
    fun providesOkHttpsBuilder(
        authQueryAppenderInterceptor: Interceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        val trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
        trustManagerFactory.init(null as KeyStore?)

        // Create an SSLContext with the trust manager
        val sslContext = SSLContext.getInstance("TLS")
        sslContext.init(null, trustManagerFactory.trustManagers, null)

        return OkHttpClient.Builder()
            .addInterceptor(authQueryAppenderInterceptor)
            .addInterceptor(httpLoggingInterceptor)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .sslSocketFactory(sslContext.socketFactory, trustManagerFactory.trustManagers[0] as X509TrustManager)
            .hostnameVerifier { _, _ -> true } // Accept all hostnames (disable hostname verification)
            .build()
    }


    @[Provides Singleton]
    fun providesJson(): Json =
        Json { ignoreUnknownKeys = true }

    @[Provides Singleton]
    fun providesRetrofit(json: Json, okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .client(okHttpClient)
            .build()

    @[Provides Singleton]
    fun providesApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)
}
