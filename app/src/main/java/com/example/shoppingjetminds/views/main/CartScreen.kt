package com.example.shoppingjetminds.views.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.shoppingjetminds.R
import com.example.shoppingjetminds.components.CartListItem
import com.example.shoppingjetminds.components.JetSimpleButton
import com.example.shoppingjetminds.components.JetText
import com.example.shoppingjetminds.components.JetTextField
import com.example.shoppingjetminds.ui.theme.Background
import com.example.shoppingjetminds.ui.theme.LighterGray
import com.example.shoppingjetminds.ui.theme.Primary
import com.example.shoppingjetminds.ui.theme.RedColor

@Composable
fun CartScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Background)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
            ) {
                HeadingSection()
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(6f),
                verticalArrangement = Arrangement.Top
            ) {
                ItemListSection()
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
            ) {
                PromoSection()
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(4f)
            ) {
                CheckoutSection()
            }
        }
    }
}

@Composable
fun HeadingSection() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(40.dp)
        .background(Color.Transparent)
    ) {

        Box(modifier = Modifier
            .background(Color.Transparent)
            .fillMaxHeight()
            .weight(1f),
            contentAlignment = Alignment.CenterStart
        ) {
            Image(
                painter = painterResource(id = R.drawable.cart),
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .padding(start = 2.dp),
                contentScale = ContentScale.Crop
            )

            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent)
                .padding(top = 10.dp),
                contentAlignment = Alignment.TopStart
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(RedColor),
                    modifier = Modifier
                        // Set image size to 4 dp
                        .size(9.dp)
                        // Clip image to be shaped as a circle
                        .clip(CircleShape)
                )
            }
        }

        Column(modifier = Modifier
            .fillMaxHeight()
            .weight(8f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            JetText(
                text = "سبد خرید",
                fontWeight = FontWeight.Bold,
                fontSize = 23
            )
        }

        Column(modifier = Modifier
            .fillMaxHeight()
            .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.arrow_left),
                contentDescription = null
            )
        }
    }
}

@Composable
fun ItemListSection() {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(15.dp),
        content = {
        items(count = 3) {
            CartListItem()
        }
    })
}

@Composable
fun PromoSection() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(56.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        Column(modifier = Modifier
            .fillMaxHeight()
            .weight(3.8f),
            verticalArrangement = Arrangement.Bottom
        ) {
            JetTextField(
                placeholder = "کد تخفیف",
                onValueChange = {},
                height = 56,
                shape = 12,
                singleLine = true,
                modifier = Modifier.wrapContentWidth()
            )
        }

        Column(modifier = Modifier
            .fillMaxHeight()
            .weight(1.2f),
            verticalArrangement = Arrangement.Bottom
        ) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Primary
                ),
                contentPadding = PaddingValues(0.dp)
            ) {
                JetText(
                    text = "اعمال کد",
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun CheckoutSection() {
    Card(
        modifier = Modifier.fillMaxSize(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    JetText(
                        text = "جمع جزء",
                        fontSize = 16,
                        fontWeight = FontWeight.Bold
                    )
                    JetText(
                        text = "49.000 تومان",
                        fontSize = 15,
                        fontWeight = FontWeight.Normal
                    )
                }

                Divider()

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    JetText(
                        text = "مالیات",
                        fontSize = 16,
                        fontWeight = FontWeight.Bold
                    )
                    JetText(
                        text = "4.000 تومان",
                        fontSize = 15,
                        fontWeight = FontWeight.Normal
                    )
                }

                Divider()

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    JetText(
                        text = "جمع کل",
                        fontSize = 16,
                        fontWeight = FontWeight.Bold
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(5.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        JetText(
                            text = "(3 آیتم)",
                            fontSize = 12,
                            fontWeight = FontWeight.Normal,
                            color = LighterGray
                        )
                        JetText(
                            text = "53.000 تومان",
                            fontSize = 15,
                            fontWeight = FontWeight.Normal
                        )
                    }
                }
            }

            Column {
                JetSimpleButton(
                    onClick = { /*TODO*/ },
                    text = "ادامه جهت تسویه حساب"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_HeadingSection() {
    HeadingSection()
}

@Preview(showBackground = true)
@Composable
fun Preview_ItemListSection() {
    ItemListSection()
}

@Preview
@Composable
fun Preview_PromoSection() {
    PromoSection()
}

@Preview
@Composable
fun Preview_CheckoutSection() {
    CheckoutSection()
}

@Preview
@Composable
fun Preview_CartScreen() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
        CartScreen()
    }
}