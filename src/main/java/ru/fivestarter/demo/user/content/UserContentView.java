package ru.fivestarter.demo.user.content;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class UserContentView extends VerticalLayout {

    private final VerticalLayout containerView = new VerticalLayout();

    public UserContentView() {
        addComponents(new Label("User list"), containerView);
    }

    public VerticalLayout getContainerView() {
        return containerView;
    }
}
