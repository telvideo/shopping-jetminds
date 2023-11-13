/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 11/11/23, 1:51 PM
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

package com.example.domain.use_cases.cart

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CalculateTotalPriceUseCase {
    operator fun invoke(subTotal: Int, tax: Int): Flow<Int?> = flow {
        if (subTotal == 0) {
            emit(0)
        } else {
            emit(subTotal + tax)
        }
    }
}