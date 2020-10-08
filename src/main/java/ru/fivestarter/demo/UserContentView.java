package ru.fivestarter.demo;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class UserContentView extends VerticalLayout {

    public VerticalLayout getContainerView() {
        return containerView;
    }

    private final VerticalLayout containerView = new VerticalLayout();

    public UserContentView() {
        addComponent(new Label("User list"));

    }
}
