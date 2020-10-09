package ru.fivestarter.demo.user.content;

import org.apache.commons.lang3.StringUtils;

import com.vaadin.ui.Label;

import ru.fivestarter.demo.user.User;
import java.io.Serializable;

public class UserContentPresenter implements Serializable {
    private final UserContentView userContentView;

    public UserContentPresenter(UserContentView userContentView) {
        this.userContentView = userContentView;
    }

    public void addUser(User user) {
        userContentView.getContainerView().addComponent(new Label(toStringLabelText(user)));
    }

    //where should it be?
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
