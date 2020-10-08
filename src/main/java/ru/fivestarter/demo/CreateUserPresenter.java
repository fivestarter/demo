package ru.fivestarter.demo;

public class CreateUserPresenter {

    private final CreateUserWindow createUserWindow;

    public CreateUserPresenter(CreateUserWindow createUserWindow) {
        this.createUserWindow = createUserWindow;
    }

    public void setOnClickButtonListener(UserInterface userInterface) {
        createUserWindow.setUserInterface(userInterface);
    }

    public interface UserInterface {
        void getUser(User user);
    }
}
