package ru.fivestarter.demo;

import com.vaadin.ui.VerticalLayout;

public class MainView extends VerticalLayout {

    private UserContentView userContentView = new UserContentView();

    public UserContentView getUserContentView() {
        return userContentView;
    }
}
