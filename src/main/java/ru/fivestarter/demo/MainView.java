package ru.fivestarter.demo;

import ru.fivestarter.demo.user.content.UserContentView;

import com.vaadin.ui.VerticalLayout;

public class MainView extends VerticalLayout {

    private UserContentView userContentView = new UserContentView();

    public UserContentView getUserContentView() {
        return userContentView;
    }
}
