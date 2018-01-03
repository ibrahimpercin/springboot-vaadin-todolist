package com.ibrahimpercin.todolist;


import com.ibrahimpercin.todolist.model.Todo;

public interface TodoChangeListener {
    void todoChanged(Todo todo);
}