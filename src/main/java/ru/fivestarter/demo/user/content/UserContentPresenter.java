package ru.fivestarter.demo.user.content;

import java.io.Serializable;

import com.vaadin.ui.Label;

import ru.fivestarter.demo.user.dao.User;

public class UserContentPresenter implements Serializable {
    private final UserContentView userContentView;

    public UserContentPresenter(UserContentView userContentView) {
        this.userContentView = userContentView;
    }

    public void addUser(User user) {
        userContentView.getContainerView().addComponent(new Label(user.toStringLabelText()));
    }
}
