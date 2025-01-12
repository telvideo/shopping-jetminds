/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 10/14/23, 11:09 PM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.repository.mappers

import com.example.cache.models.*
import com.example.network.models.*

fun CouponsResponseDto.toEntity(): CouponsResponseEntity =
    CouponsResponseEntity(
        this.id,
        this.code,
        this.amount,
        this.status,
        this.dateCreated,
        this.dateCreatedGmt,
        this.discountType,
        this.description,
        this.dateExpires,
        this.dateExpiresGmt,
        this.usageCount,
        this.individualUse,
        this.productIds?.map { it },
        this.excludedProductIds?.map { it },
        this.usageLimit,
        this.usageLimitPerUser,
        this.limitUsageToXItems,
        this.freeShipping,
        this.productCategories?.map { it.toEntity() },
        this.excludeSaleItems,
        this.maximumAmount,
        this.minimumAmount,
        this.emailRestrictions
    )

fun OrdersResponseDto.toEntity(): OrdersResponseEntity =
    OrdersResponseEntity(
        this.id,
        this.parentId,
        this.status,
        this.currency,
        this.pricesIncludeTax,
        this.dateCreated,
        this.dateModified,
        this.discountTotal,
        this.discountTax,
        this.shippingTotal,
        this.shippingTax,
        this.cartTax,
        this.total,
        this.totalTax,
        this.customerId,
        this.orderKey,
        this.billing?.toEntity(),
        this.shipping?.toEntity(),
        this.paymentMethod,
        this.paymentMethodTitle,
        this.transactionId,
        this.customerIpAddress,
        this.customerNote,
        this.dateCompleted,
        this.datePaid,
        this.cartHash,
        this.number,
        this.lineItems?.map { it.toEntity() },
        this.taxLines?.map { it.toEntity() },
        this.shippingLines?.map { it.toEntity() },
        this.paymentUrl,
        this.dateCreatedGmt,
        this.dateModifiedGmt,
        this.dateCompletedGmt,
        this.datePaidGmt,
        this.currencySymbol
    )

fun ProductAttributesResponseDto.toEntity(): ProductAttributesResponseEntity =
    ProductAttributesResponseEntity(
        this.id,
        this.name,
        this.slug,
        this.type,
        this.orderBy,
        this.hasArchives
    )

fun ProductCategoriesResponseDto.toEntity(): ProductCategoriesResponseEntity =
    ProductCategoriesResponseEntity(
        this.id,
        this.name,
        this.slug,
        this.parent,
        this.description,
        this.display,
        this.image?.toEntity(),
        this.menuOrder,
        this.count
    )

fun ProductReviewsResponseDto.toEntity(): ProductReviewsResponseEntity =
    ProductReviewsResponseEntity(
        this.id,
        this.dateCreated,
        this.dateCreatedGmt,
        this.productId,
        this.status,
        this.reviewer,
        this.reviewerEmail,
        this.review,
        this.rating,
        this.verified,
        this.avatar?.toEntity()
    )

fun ProductShippingClassesResponseDto.toEntity(): ProductShippingClassesResponseEntity =
    ProductShippingClassesResponseEntity(
        this.id,
        this.name,
        this.slug,
        this.description,
        this.count
    )

fun ProductsResponseDto.toEntity(
    isFavorite: Boolean = false,
    downloaded: Boolean = false
): ProductsResponseEntity =
    ProductsResponseEntity(
        this.id,
        this.name,
        this.slug,
        this.dateCreated,
        this.type,
        this.status,
        this.featured,
        this.catalogVisibility,
        this.description,
        this.shortDescription,
        this.sku,
        this.price,
        this.regularPrice,
        this.salePrice,
        this.dateOnSaleFrom,
        this.dateOnSaleTo,
        this.onSale,
        this.purchasable,
        this.totalSales,
        this.taxStatus,
        this.taxClass,
        this.manageStock,
        this.stockQuantity,
        this.soldIndividually,
        this.shippingRequired,
        this.shippingTaxable,
        this.shippingClass,
        this.shippingClassId,
        this.reviewsAllowed,
        this.averageRating,
        this.ratingCount,
        this.categories?.map { it.toEntity() },
        this.tags?.map { it.toEntity() },
        this.images?.map { it.toEntity() },
        this.attributes?.map { it.toEntity() },
        this.defaultAttributes?.map { it.toEntity() },
        this.stockStatus,
        isFavorite = isFavorite,
        downloaded = downloaded
    )

fun ProductTagsResponseDto.toEntity(): ProductTagsResponseEntity =
    ProductTagsResponseEntity(
        this.id,
        this.name,
        this.slug,
        this.description,
        this.count
    )

fun ProductVariationsResponseDto.toEntity(): ProductVariationsResponseEntity =
    ProductVariationsResponseEntity(
        this.id,
        this.dateCreated,
        this.dateCreatedGmt,
        this.description,
        this.permalink,
        this.sku,
        this.price,
        this.regularPrice,
        this.salePrice,
        this.dateOnSaleFrom,
        this.dateOnSaleFromGmt,
        this.dateOnSaleTo,
        this.dateOnSaleToGmt,
        this.onSale,
        this.status,
        this.purchasable,
        this.taxStatus,
        this.taxClass,
        this.manageStock,
        this.stockQuantity,
        this.stockStatus,
        this.shippingClass,
        this.shippingClassId,
        this.image?.toEntity(),
        this.attribute?.map { it.toEntity() }
    )

fun ShippingZonesResponseDto.toEntity(): ShippingZonesResponseEntity =
    ShippingZonesResponseEntity(
        this.id,
        this.name,
        this.order
    )

fun AttributeDto.toEntity(): AttributeEntity =
    AttributeEntity(
        this.id,
        this.name,
        this.options,
        this.position,
        this.variation,
        this.visible
    )

fun BillingDto.toEntity(): BillingEntity =
    BillingEntity(
        this.address1,
        this.address2,
        this.city,
        this.company,
        this.country,
        this.email,
        this.firstName,
        this.lastName,
        this.phone,
        this.postcode,
        this.state
    )

fun CategoryDto.toEntity(): CategoryEntity =
    CategoryEntity(
        this.id,
        this.name
    )

fun DefaultAttributeDto.toEntity(): DefaultAttributeEntity =
    DefaultAttributeEntity(
        this.id,
        this.name,
        this.option
    )

fun ImageDto.toEntity(): ImageEntity =
    ImageEntity(
        this.id,
        this.name,
        this.src,
        this.alt
    )

fun LineItemDto.toEntity(): LineItemEntity = LineItemEntity(
    this.id,
    this.name,
    this.price,
    this.productId,
    this.quantity,
    this.sku,
    this.subtotal,
    this.subtotalTax,
    this.taxClass,
    this.taxes?.map { it.toEntity() },
    this.total,
    this.totalTax,
    this.variationId
)

fun ShippingDto.toEntity(): ShippingEntity =
    ShippingEntity(
        this.address1,
        this.address2,
        this.city,
        this.company,
        this.country,
        this.firstName,
        this.lastName,
        this.postcode,
        this.state
    )

fun ShippingLineDto.toEntity(): ShippingLineEntity =
    ShippingLineEntity(
        this.id,
        this.methodId,
        this.methodTitle,
        this.taxes?.map { it.toEntity() },
        this.total,
        this.totalTax
    )

fun TagDto.toEntity(): TagEntity =
    TagEntity(
        this.id,
        this.name
    )

fun TaxDto.toEntity(): TaxEntity =
    TaxEntity(
        this.id,
        this.subtotal,
        this.total
    )

fun TaxLineDto.toEntity(): TaxLineEntity =
    TaxLineEntity(
        this.id,
        this.label,
        this.compound,
        this.rateCode,
        this.rateId,
        this.shippingTaxTotal,
        this.taxTotal
    )

fun CustomersResponseDto.toEntity(): CustomersResponseEntity =
    CustomersResponseEntity(
        this.id,
        this.dateCreated,
        this.dateCreatedGmt,
        this.email,
        this.firstName,
        this.lastName,
        this.role,
        this.username,
        this.billing?.toEntity(),
        this.shipping?.toEntity(),
        this.isPayingCustomer,
        this.avatarUrl
    )

fun UserAvatarDto.toEntity(): UserAvatarEntity =
    UserAvatarEntity(
        this.size24,
        this.size48,
        this.size96
    )

fun PaymentGatewaysResponseDto.toEntity(): PaymentGatewaysResponseEntity =
    PaymentGatewaysResponseEntity(
        this.id,
        this.title,
        this.description,
        this.order,
        this.enabled,
        this.methodTitle,
        this.methodDescription,
        this.methodSupports,
        this.settings?.toEntity(),
        this.needsSetup,
        this.settingsUrl,
        this.connectionUrl,
        this.setupHelpText
    )

fun SettingsDto.toEntity(): SettingsEntity =
    SettingsEntity(
        this.baseConfig?.toEntity(),
        this.title?.toEntity(),
        this.accountConfig?.toEntity(),
        this.api?.toEntity(),
        this.merchantCode?.toEntity(),
        this.webServiceConfig?.toEntity(),
        this.apiKey?.toEntity(),
        this.successMassage?.toEntity(),
        this.failedMassage?.toEntity()
    )

fun PaymentMessageDto.toEntity(): PaymentMessageEntity =
    PaymentMessageEntity(
        this.id,
        this.label,
        this.description,
        this.type,
        this.value,
        this.default,
        this.tip,
        this.placeholder
    )