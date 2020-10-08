package ru.fivestarter.demo;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

import ru.fivestarter.demo.user.content.UserContentView;
import java.io.Serializable;

public class MainView extends VerticalLayout {

    private Button addUserButton;
    private final UserContentView userContentView = new UserContentView();

    private MainPresenter.CreateUserInterface createUserInterface;

    public MainView() {
        super();
        initElements();
        initListeners();
        buildLayout();
    }

    public void setOnClickAddUserButtonListener(MainPresenter.CreateUserInterface createUserInterface) {
        this.createUserInterface = createUserInterface;
    }

    public UserContentView getUserContentView() {
        return userContentView;
    }

    private void initElements() {
        addUserButton = new Button("Add user");
    }

    private void initListeners() {
        addUserButton.addClickListener(event -> createUserInterface.create());
    }

    private void buildLayout() {
        addComponents(addUserButton, userContentView);
        setComponentAlignment(addUserButton, Alignment.BOTTOM_CENTER);
    }
}
