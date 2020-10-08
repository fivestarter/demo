package ru.fivestarter.demo;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

import ru.fivestarter.demo.user.content.UserContentPresenter;
import ru.fivestarter.demo.user.creation.CreateUserPresenter;
import ru.fivestarter.demo.user.creation.CreateUserWindow;

@SpringUI
@Theme("valo")
public class MainPresenter extends UI {

    private CreateUserPresenter createUserPresenter;
    private UserContentPresenter userContentPresenter;
    private MainView mainView = new MainView();
    private CreateUserWindow createUserWindow = new CreateUserWindow();

    @Override
    protected void init(VaadinRequest request) {
        initElements();
        initListeners();
        buildLayout();
    }

    private void initElements() {
        userContentPresenter = new UserContentPresenter(mainView.getUserContentView());
        createUserPresenter = new CreateUserPresenter(createUserWindow);
    }

    private void initListeners() {
        mainView.setCreateUserInterface(() -> UI.getCurrent().addWindow(createUserWindow));
        createUserPresenter.setOnClickButtonListener(user -> userContentPresenter.addUser(user));
    }

    private void buildLayout() {
        setContent(mainView);
    }

    public interface CreateUserInterface {
        void create();
    }
}