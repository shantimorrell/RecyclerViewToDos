package com.example.recyclerviewtodos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ToDoAdapter : Adapter<ToDoAdapter.ToDoViewHolder>(){
    val toDos: MutableList<ToDo> = mutableListOf()

    override fun getItemCount() = toDos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.todo_list_item, parent, false)
        return ToDoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        holder.bind(toDos[position])
    }


    fun addToDo(toDo: ToDo) {
        toDos.add(0, toDo)
        notifyItemInserted(0)
    }

    class ToDoViewHolder(view: View) : ViewHolder(view) {
        private val checkBox: CheckBox = view.findViewById(R.id.todo_checkbox)
        private val toDoTextTV: TextView = view.findViewById(R.id.tv_todo_text)
        private var currentToDo: ToDo? = null

        init {
            checkBox.setOnCheckedChangeListener {
                    _, isChecked -> currentToDo?.isCompleted = isChecked
            }
        }


        fun bind(toDo: ToDo) {
            currentToDo = toDo
            checkBox.isChecked = toDo.isCompleted
            toDoTextTV.text = toDo.text
        }
    }
}