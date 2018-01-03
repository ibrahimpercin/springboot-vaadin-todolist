package com.ibrahimpercin.todolist;

import com.ibrahimpercin.todolist.model.Todo;
import com.vaadin.annotations.Theme;
import com.vaadin.event.ShortcutAction;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Theme("valo")
public class TodoUI extends UI {

    private VerticalLayout root;

    @Autowired
    TodoList todoList;

    @Override
    protected void init(VaadinRequest request) {
        setupLayout();
        addHeader();
        addForm();
        addTodoList();
        addDeleteButton();
    }

    private void setupLayout() {
        root = new VerticalLayout();
        root.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setContent(root);
    }

    private void addHeader() {
        Label header = new Label("TODOs");
        header.addStyleName(ValoTheme.LABEL_H1);
        root.addComponent(header);
    }

    private void addForm() {
        HorizontalLayout formLayout = new HorizontalLayout();
        formLayout.setWidth("80%");

        TextField taskField = new TextField();
        Button addButton = new Button("");

        addButton.setIcon(VaadinIcons.PLUS);
        addButton.addStyleName(ValoTheme.BUTTON_PRIMARY);

        formLayout.addComponentsAndExpand(taskField);
        formLayout.addComponents(addButton);


        addButton.addClickListener(click -> {
            todoList.add(new Todo(taskField.getValue()));
            taskField.setValue("");
            taskField.focus();
        });
        taskField.focus();
        addButton.setClickShortcut(ShortcutAction.KeyCode.ENTER);

        root.addComponent(formLayout);
    }

    private void addTodoList() {
        todoList.setWidth("80%");
        root.addComponent(todoList);
    }

    private void addDeleteButton() {
        root.addComponent(new Button("Delete Completed Tasks", click -> {
            todoList.deleteCompleted();
        }));
    }

}
