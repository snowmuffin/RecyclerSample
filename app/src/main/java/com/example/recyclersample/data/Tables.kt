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

import android.content.res.Resources

/* Returns initial list of tables. */
fun tableList(resources: Resources): List<Table> {




    fun newtable(newid: Long,newname: String,newmaxper:Int):Table{

        return Table(
            id = newid,
            name = newname,
            maxper = newmaxper,
            curper = 0,
            course =0,
            starter = mapOf("Zuppa" to 0, "Melanzane" to 0, "Scallop" to 0, "Ricotta Salad" to 0, "Burata Salad" to 0, "Manzo Salad" to 0),
            pizza = mapOf("Margherita" to 0, "Pepperoni" to 0, "Funghi" to 0, "Gorgonzola" to 0, "Rucola & prosciutto" to 0, "Burrta & Mortadella" to 0),
            pasta = mapOf("Allio e olio" to 0, "Vongole" to 0, "Uova di Merlunzzo" to 0, "Capesante" to 0, "Uni &  Bisque" to 0, "Amatriciana" to 0, "Ragu Bolognese" to 0, "Mare" to 0,"Cream mare(Risotto)" to 0, "Rose Manzo" to 0, "Carbonara" to 0,"Gamberi Crema" to 0,"Quattro Funghi" to 0),
            risotto = mapOf("Ragu Bolognese(Risotto)" to 0,"Bistrcca(Risotto)" to 0,"Mare(Risotto)" to 0,"Cream mare(Risotto)" to 0,"Seppia(Risotto)" to 0),
            steak = mapOf("YBD Pork" to 0, "Salmon" to 0, "Tender" to 0, "Lamb" to 0),
            coffe = mapOf("Espresso" to 0, "Americano" to 0, "Cappuccino" to 0, "Caffe latte" to 0, "Vanilla latte" to 0,"Caffe mocha" to 0, "Caramel latte" to 0, "Hazelnut latte" to 0, "Caramel macchioato" to 0, "Affogato" to 0,"Ice cream" to 0),
            noncoffe = mapOf("Ice tea" to 0, "Hot chocolate" to 0, "Royal milk tea" to 0, "Sweetpotato latte" to 0),
            ade = mapOf("Green grape" to 0, "Grapefruit" to 0, "Blue Lemon" to 0, "Wine ade" to 0),
            smoothjuice = mapOf("Strawberry" to 0, "Blueberry" to 0, "Mango" to 0),
            juice = mapOf("Tomato" to 0, "Orange" to 0),
            tea = mapOf("Chamomile" to 0, "Pepperment" to 0, "Lady grey" to 0, "Lemon puer" to 0),
            traditional = mapOf("Yuza" to 0, "Ginger" to 0, "Jujube" to 0),

            beer = mapOf("Heineken" to 0),
            wine = mapOf("Red bottle" to 0, "Red glass" to 0, "White bottle" to 0, "White glass" to 0, "Sparkling bottle" to 0, "Sparkling glass" to 0)
        )
    }
    return listOf(
        newtable(1,"1",4),
        newtable(2,"2",4),
        newtable(3,"3",4),
        newtable(4,"4",4),
        newtable(5,"5",4),
        newtable(6,"5-2",2),
        newtable(7,"6", 4),
        newtable(8,"7",4),
        newtable(9,"8",4),
        newtable(10,"9",4),
        newtable(11,"10",4),
        newtable(12,"10-1",4),
        newtable(13,"10-2",4),
        newtable(14,"10-3",4),
        newtable(15,"10-4",4),

    )
}
