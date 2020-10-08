package ru.fivestarter.demo;

import ru.fivestarter.demo.user.content.UserContentPresenter;
import ru.fivestarter.demo.user.creation.CreateUserPresenter;
import ru.fivestarter.demo.user.creation.CreateUserWindow;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI
@Theme("valo")
public class MainPresenter extends UI {

    private Button clickMeButton;
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
        clickMeButton = new Button("Click Me");
        userContentPresenter = new UserContentPresenter(mainView.getUserContentView());
        createUserPresenter = new CreateUserPresenter(createUserWindow);
    }

    private void initListeners() {
        clickMeButton.addClickListener(event -> UI.getCurrent().addWindow(createUserWindow));
        createUserPresenter.setOnClickButtonListener(user -> userContentPresenter.addUser(user));
    }

    private void buildLayout() {
        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.addComponent(clickMeButton);
        mainLayout.addComponent(mainView.getUserContentView());
        mainLayout.setComponentAlignment(clickMeButton, Alignment.BOTTOM_CENTER);
        setContent(mainLayout);
    }

}
