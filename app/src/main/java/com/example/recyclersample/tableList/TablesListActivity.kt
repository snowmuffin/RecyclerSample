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

package com.example.recyclersample.tableList

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclersample.addTable.AddTableActivity
import com.example.recyclersample.tableDetail.TableDetailActivity
import com.example.recyclersample.R
import com.example.recyclersample.addTable.MAX_PER
import com.example.recyclersample.addTable.TABLE_NAME
import com.example.recyclersample.data.Table

const val TABLE_ID = "table id"

class TablesListActivity : AppCompatActivity() {
    private val newTableActivityRequestCode = 1
    private val tablesListViewModel by viewModels<TablesListViewModel> {
        TablesListViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* Instantiates headerAdapter and tablesAdapter. Both adapters are added to concatAdapter.
        which displays the contents sequentially */
        val headerAdapter = HeaderAdapter()
        val tablesAdapter = TablesAdapter { table -> adapterOnClick(table) }
        val concatAdapter = ConcatAdapter(headerAdapter, tablesAdapter)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = concatAdapter

        tablesListViewModel.tablesLiveData.observe(this, {
            it?.let {
                tablesAdapter.submitList(it as MutableList<Table>)
                headerAdapter.updateTableCount(it.size)
            }
        })

        val fab: View = findViewById(R.id.fab)
        fab.setOnClickListener {
            fabOnClick()
        }
    }

    /* Opens TableDetailActivity when RecyclerView item is clicked. */
    private fun adapterOnClick(table: Table) {
        val intent = Intent(this, TableDetailActivity()::class.java)
        intent.putExtra(TABLE_ID, table.id)
        startActivity(intent)
    }

    /* Adds table to tableList when FAB is clicked. */
    private fun fabOnClick() {
        val intent = Intent(this, AddTableActivity::class.java)
        startActivityForResult(intent, newTableActivityRequestCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        /* Inserts table into viewModel. */
        if (requestCode == newTableActivityRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.let { data ->
                val tableName = data.getStringExtra(TABLE_NAME)
                val per = data.getStringExtra(MAX_PER)

                tablesListViewModel.insertTable(tableName, per)
            }
        }
    }
}
