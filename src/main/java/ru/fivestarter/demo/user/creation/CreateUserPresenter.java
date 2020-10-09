package ru.fivestarter.demo.user.creation;

import java.io.Serializable;

public class CreateUserPresenter implements Serializable {

    private final CreateUserWindow createUserWindow;

    public CreateUserPresenter(CreateUserWindow createUserWindow) {
        this.createUserWindow = createUserWindow;
    }

    public void setOnClickCreateUserButtonListener(CreateUserWindow.CreateUserButtonListener createUserButtonListener) {
        createUserWindow.setOnClickCreateUserButtonListener(createUserButtonListener);
    }
}
