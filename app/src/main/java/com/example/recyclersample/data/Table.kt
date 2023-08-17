/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.recyclersample.data

import androidx.annotation.DrawableRes

data class Table(
    val id: Long,
    val name: String,
    val maxper: Int,
    val curper: Int,
    val course: Int,
    val starter: Map<String, Int>,
    val pizza: Map<String, Int>,
    val pasta: Map<String, Int>,
    val risotto: Map<String, Int>,
    val steak: Map<String, Int>,
    val coffe: Map<String, Int>,
    val noncoffe: Map<String, Int>,
    val ade: Map<String, Int>,
    val juice: Map<String, Int>,
    val tea: Map<String, Int>,
    val traditional: Map<String, Int>,
    val smoothjuice: Map<String, Int>,
    val beer: Map<String, Int>,
    val wine: Map<String, Int>,

    )