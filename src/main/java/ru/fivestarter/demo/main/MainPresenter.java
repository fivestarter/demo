package ru.fivestarter.demo.main;

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

    private final MainView mainView = new MainView();
    //should it be in Main view?
    private final CreateUserWindow createUserWindow = new CreateUserWindow();
    private CreateUserPresenter createUserPresenter;
    private UserContentPresenter userContentPresenter;

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
        mainView.setOnClickAddUserButtonListener(() -> UI.getCurrent().addWindow(createUserWindow));
        createUserPresenter.setOnClickCreateUserButtonListener(user -> userContentPresenter.addUser(user));
    }

    private void buildLayout() {
        setContent(mainView);
    }
}
