package ru.fivestarter.demo.user.creation;

import ru.fivestarter.demo.user.User;
import java.io.Serializable;

public class CreateUserPresenter implements Serializable {

    private final CreateUserWindow createUserWindow;

    public CreateUserPresenter(CreateUserWindow createUserWindow) {
        this.createUserWindow = createUserWindow;
    }

    public void setOnClickCreateUserButtonListener(CreateUserButtonListener createUserButtonListener) {
        createUserWindow.setOnClickCreateUserButtonListener(createUserButtonListener);
    }

    //todo rename
    //where should it be?
    public interface CreateUserButtonListener extends Serializable {
        void getUser(User user);
    }
}
