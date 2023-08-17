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

package com.example.recyclersample.tableDetail

import android.os.Bundle
import android.widget.Button

import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclersample.R
import com.example.recyclersample.tableList.TABLE_ID


class TableDetailActivity : AppCompatActivity() {

    private val tableDetailViewModel by viewModels<TableDetailViewModel> {
        TableDetailViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.table_detail_activity)

        var currentTableId: Long? = null

        /* Connect variables to UI elements. */
        val tableName: TextView = findViewById(R.id.table_detail_name)

        val customer: TextView = findViewById(R.id.customer)
        val removeTableButton: Button = findViewById(R.id.remove_button)

        var tablemenu: TextView=findViewById(R.id.table_menu)
        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            currentTableId = bundle.getLong(TABLE_ID)
        }

        /* If currentTableId is not null, get corresponding table and set name, image and
        description */
        currentTableId?.let {
            val currentTable = tableDetailViewModel.getTableForId(it)
            tableName.text = currentTable?.name

            customer.text = currentTable?.curper.toString()+"/"+currentTable?.maxper.toString()/*인원수 표시*/
            val ordered = currentTable!!.starter.filter {(_, value) -> value > 0 }
            tablemenu.text=ordered.toString()
            removeTableButton.setOnClickListener {
                if (currentTable != null) {
                    tableDetailViewModel.removeTable(currentTable)
                }
                finish()
            }
        }


    }
}
