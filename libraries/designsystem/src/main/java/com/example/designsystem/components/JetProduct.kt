/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 11/9/23, 2:26 PM
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

package com.example.designsystem.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.designsystem.LighterBlack
import com.example.designsystem.LighterGray
import com.example.designsystem.R
import com.example.designsystem.RedColor
import com.example.designsystem.YellowColor

@Composable
fun JetProduct(
    title: String,
    image: String? = null,
    price: String? = null,
    rating: String? = null,
    category: String? = null,
    onAddToCartClick: () -> Unit,
    onProductClick: () -> Unit,
    onFavoriteBtnClick: () -> Unit,
    isFavorite: Boolean = false
) {

    Card(
        modifier = Modifier
            .size(280.dp)
            .clickable(enabled = true, onClick = { onProductClick() }),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Feature image
            Box(modifier = Modifier
                .fillMaxWidth()
                .weight(6f),
                contentAlignment = Alignment.TopEnd
            ) {
                image?.let {
                    JetCoilImage(
                        imageUrl = it,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(shape = RoundedCornerShape(8.dp))
                    )
                }
                LikeButton(
                    onCLick = { onFavoriteBtnClick() },
                    isFavorite = isFavorite
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(3f),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.Top
                    ) {
                        // Title
                        JetText(
                            text = title,
                            fontSize = 14,
                            fontWeight = FontWeight.SemiBold,
                            maxLines = 2,
                            textAlign = TextAlign.Start,
                            lineHeight = 1.5,
                            modifier = Modifier
                                .wrapContentHeight()
                                .weight(8f)
                        )

                        Row(modifier = Modifier
                            .wrapContentHeight()
                            .weight(2f),
                            verticalAlignment = Alignment.Top,
                            horizontalArrangement = Arrangement.End
                        ) {
                            JetText(
                                text = "($rating)",
                                fontSize = 12
                            )

                            Icon(
                                painter = painterResource(id = R.drawable.star),
                                contentDescription = null,
                                tint = YellowColor,
                                modifier = Modifier
                                    .size(14.dp)
                                    .padding(top = 1.dp)
                            )
                        }
                    }
                }

                Column(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Column(modifier = Modifier
                            .wrapContentHeight()
                            .weight(8f)
                        ) {
                            if (category != null) {
                                JetText(
                                    text = category,
                                    color = LighterGray,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 9
                                )
                            } else {
                                JetText(
                                    text = "بدون دسته بندی",
                                    color = LighterBlack,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 9
                                )
                            }

                            // Price start
                            Row(modifier = Modifier
                                .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(5.dp)
                            ) {
                                JetPriceText(price = price!!)
                            }
                            // Price end
                        }
                        Column(modifier = Modifier
                            .fillMaxHeight()
                            .weight(2f),
                            verticalArrangement = Arrangement.Bottom
                        ) {
                            BuyButton(
                                onCLick = { onAddToCartClick() },
                                shape = 6,
                                modifier = Modifier.fillMaxWidth().height(30.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun JetShopProduct(
    title: String,
    image: String? = null,
    price: String? = null,
    rating: String? = "4.5",
    category: String? = null,
    onAddToCartClick: () -> Unit,
    onProductClick: () -> Unit,
    onFavoriteBtnClick: () -> Unit,
    isFavorite: Boolean = false
) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .height(280.dp)
            .clickable(enabled = true, onClick = { onProductClick() }),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Feature image
            Box(modifier = Modifier
                .fillMaxWidth()
                .weight(6f),
                contentAlignment = Alignment.TopCenter
            ) {
                // Feature image
                image?.let {
                    JetCoilImage(
                        imageUrl = it,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(shape = RoundedCornerShape(8.dp))
                    )
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Rating
                    Card(modifier = Modifier
                        .wrapContentSize(),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        shape = RoundedCornerShape(4.dp),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 4.dp
                        )
                    ) {
                        Column(modifier = Modifier
                            .padding(horizontal = 5.dp)
                        ) {
                            JetStarText(
                                rate = if (rating?.isEmpty() == true) 0.00F else rating?.toFloat(),
                                textSize = 13,
                                iconSize = 15
                            )
                        }
                    }
                    // Like button
                    LikeButton(
                        onCLick = { onFavoriteBtnClick() },
                        isFavorite = isFavorite
                    )
                }
            }

            Spacer(modifier = Modifier.height(5.dp))

            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(3f),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.Top
                    ) {
                        // Title
                        JetText(
                            text = title,
                            fontSize = 12,
                            fontWeight = FontWeight.SemiBold,
                            maxLines = 2,
                            textAlign = TextAlign.Start,
                            lineHeight = 1.5
                        )
                    }
                }

                Column(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Column(modifier = Modifier
                            .wrapContentHeight()
                            .weight(8f),
                            verticalArrangement = Arrangement.Bottom
                        ) {
                            // Category
                            if (category != null) {
                                JetText(
                                    text = category,
                                    color = LighterGray,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 10
                                )
                            } else {
                                JetText(
                                    text = "بدون دسته بندی",
                                    color = LighterBlack,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 10
                                )
                            }

                            // Price
                            Row(modifier = Modifier
                                .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(5.dp)
                            ) {
                                JetPriceText(price = price!!)
                            }
                        }
                        Column(modifier = Modifier
                            .fillMaxHeight()
                            .weight(2f)
                            .padding(vertical = 5.dp),
                            verticalArrangement = Arrangement.Bottom
                        ) {
                            BuyButton(
                                onCLick = { onAddToCartClick() }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AddOnSaleProductTimers(
    days: Int? = null,
    hours: Int? = null,
    minutes: Int? = null,
    seconds: Int? = null
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Seconds
        Column(modifier = Modifier
            .weight(1f)
            .height(30.dp)
            .fillMaxSize()
            .background(color = LighterGray, shape = RoundedCornerShape(3.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            JetText(
                text = "$seconds",
                fontSize = 10,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center,
                color = RedColor
            )
            JetText(
                text = "ثانیه",
                fontSize = 6,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center
            )

        }
        // Minutes
        Column(modifier = Modifier
            .weight(1f)
            .height(30.dp)
            .fillMaxSize()
            .background(color = LighterGray, shape = RoundedCornerShape(3.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            JetText(
                text = "$minutes",
                fontSize = 10,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center,
                color = RedColor
            )
            JetText(
                text = "دقیقه",
                fontSize = 6,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center
            )
        }
        // Hours
        Column(modifier = Modifier
            .weight(1f)
            .height(30.dp)
            .fillMaxSize()
            .background(color = LighterGray, shape = RoundedCornerShape(3.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            JetText(
                text = "$hours",
                fontSize = 10,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center,
                color = RedColor
            )
            JetText(
                text = "ساعت",
                fontSize = 6,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center
            )
        }
        // Days
        Column(modifier = Modifier
            .weight(1f)
            .height(30.dp)
            .fillMaxSize()
            .background(color = LighterGray, shape = RoundedCornerShape(3.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            JetText(
                text = "$days",
                fontSize = 10,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center,
                color = RedColor
            )
            JetText(
                text = "روز",
                fontSize = 6,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center
            )
        }
    }
}


@Preview
@Composable
private fun Preview_JetProduct() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
        JetProduct(
            title = "کیت رابط کاربری Magenest – eCommerce App UI Kit",
            image = "",
            price = "39000",
            rating = "4.6",
            category = "کیت رابط کاربری",
            onAddToCartClick = {},
            onProductClick = {},
            onFavoriteBtnClick = {},
            isFavorite = false
        )
    }
}

@Preview
@Composable
private fun Preview_JetShopProduct() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
        JetShopProduct(
            title = "کیت رابط کاربری Magenest – eCommerce App UI Kit",
            image = "",
            price = "39000",
            rating = "",
            category = "کیت رابط کاربری",
            onAddToCartClick = {},
            onProductClick = {},
            onFavoriteBtnClick = {},
            isFavorite = false
        )
    }
}