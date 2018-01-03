package com.ibrahimpercin.todolist;

import com.ibrahimpercin.todolist.model.Todo;
import com.vaadin.data.Binder;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

public class TodoLayout extends HorizontalLayout {
    private final CheckBox done;
    private final TextField text;

    public TodoLayout(Todo todo, TodoChangeListener changeListener) {
        done = new CheckBox();
        text = new TextField();
        text.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
        text.setValueChangeMode(ValueChangeMode.BLUR);

        setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);

        Binder<Todo> binder = new Binder<>(Todo.class);
        binder.bindInstanceFields(this);
        binder.setBean(todo);

        addComponents(done);
        addComponentsAndExpand(text);

        binder.addValueChangeListener(event -> changeListener.todoChanged(todo));

    }
}
