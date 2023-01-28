package com.example.recyclerviewtodos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toDoEntryET = findViewById<EditText>(R.id.et_todo_entry)
        val addToDoBtn = findViewById<Button>(R.id.btn_add_todo)

        val toDoListRV: RecyclerView = findViewById(R.id.rv_todo_list)
        toDoListRV.layoutManager = LinearLayoutManager(this)
        toDoListRV.setHasFixedSize(true)

        val adapter = ToDoAdapter()
        toDoListRV.adapter = adapter

        addToDoBtn.setOnClickListener {
            val newToDo = toDoEntryET.text.toString()
            if (!TextUtils.isEmpty(newToDo)) {
                adapter.addToDo(ToDo(newToDo))
                toDoListRV.scrollToPosition(0)
                toDoEntryET.setText("")
            }
        }
    }
}