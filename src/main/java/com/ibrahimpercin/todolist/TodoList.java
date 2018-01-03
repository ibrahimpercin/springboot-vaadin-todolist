package com.ibrahimpercin.todolist;

import com.ibrahimpercin.todolist.model.Todo;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class TodoList extends VerticalLayout implements TodoChangeListener{

    private List<Todo> todos;

    @Autowired
    TodoRepository todoRepository;

    @PostConstruct
    void init() {
        setWidth("80%");
        update();
    }

    private void update() {
        setTodos(todoRepository.findAll());
    }

    private void setTodos(List<Todo> todos) {
        this.todos = todos;
        removeAllComponents();
        todos.forEach(todo -> addComponent(new TodoLayout(todo, this)));
    }

    public void add(Todo todo){
        todoRepository.save(todo);
        update();
    }


    @Override
    public void todoChanged(Todo todo) {
        add(todo);
    }

    public void deleteCompleted() {
        todoRepository.deleteByDone(true);
        update();
    }
}
