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

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclersample.R
import com.example.recyclersample.data.Table

class TablesAdapter(private val onClick: (Table) -> Unit) :
    ListAdapter<Table, TablesAdapter.TableViewHolder>(TableDiffCallback) {

    /* ViewHolder for Table, takes in the inflated view and the onClick behavior. */
    class TableViewHolder(itemView: View, val onClick: (Table) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private val tableTextView: TextView = itemView.findViewById(R.id.table_text)
        private var currentTable: Table? = null

        init {
            itemView.setOnClickListener {
                currentTable?.let {
                    onClick(it)
                }
            }
        }

        /* Bind table name and image. */
        fun bind(table: Table) {
            currentTable = table

            tableTextView.text = table.name /*이름*/

        }
    }

    /* Creates and inflates view and return TableViewHolder. */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.table_item, parent, false)
        return TableViewHolder(view, onClick)
    }

    /* Gets current table and uses it to bind view. */
    override fun onBindViewHolder(holder: TableViewHolder, position: Int) {
        val table = getItem(position)
        holder.bind(table)

    }
}

object TableDiffCallback : DiffUtil.ItemCallback<Table>() {
    override fun areItemsTheSame(oldItem: Table, newItem: Table): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Table, newItem: Table): Boolean {
        return oldItem.id == newItem.id
    }
}
