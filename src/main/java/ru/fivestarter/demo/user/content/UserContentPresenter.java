package ru.fivestarter.demo.user.content;

import ru.fivestarter.demo.user.User;

import org.apache.commons.lang3.StringUtils;

import com.vaadin.ui.Label;

public class UserContentPresenter {
    private UserContentView userContentView;

    public UserContentPresenter(UserContentView userContentView) {
        this.userContentView = userContentView;
    }

    public void addUser(User user) {
        userContentView.getContainerView().addComponent(new Label(toStringLabelText(user)));
    }

    private String toStringLabelText(User user) {
        return user.getLogin() +
                StringUtils.SPACE +
                user.getFirstName() +
                StringUtils.SPACE +
                user.getLastName() +
                StringUtils.SPACE +
                user.getBirthdate();
    }
}
