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

package com.example.recyclersample.addTable

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclersample.R
import com.google.android.material.textfield.TextInputEditText

const val TABLE_NAME = "name"
const val MAX_PER = "max person"

class AddTableActivity : AppCompatActivity() {
    private lateinit var addTableName: TextInputEditText
    private lateinit var addTableMax: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_table_layout)

        findViewById<Button>(R.id.done_button).setOnClickListener {
            addTable()
        }
        addTableName = findViewById(R.id.add_table_name)
        addTableMax = findViewById(R.id.add_table_maxper)
    }

    /* The onClick action for the done button. Closes the activity and returns the new table name
    and description as part of the intent. If the name or description are missing, the result is set
    to cancelled. */

    private fun addTable() {
        val resultIntent = Intent()

        if (addTableName.text.isNullOrEmpty() || addTableMax.text.isNullOrEmpty()) {
            setResult(Activity.RESULT_CANCELED, resultIntent)
        } else {
            val name = addTableName.text.toString()
            val maxper = addTableMax.text.toString()
            resultIntent.putExtra(TABLE_NAME, name)
            resultIntent.putExtra(MAX_PER, maxper)
            setResult(Activity.RESULT_OK, resultIntent)
        }
        finish()
    }
}
