package ru.fivestarter.demo;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

import ru.fivestarter.demo.user.content.UserContentView;

public class MainView extends VerticalLayout {

    private Button addUserButton;
    private final UserContentView userContentView = new UserContentView();

    private MainPresenter.AddUserInterface addUserInterface;

    public MainView() {
        super();
        initElements();
        initListeners();
        buildLayout();
    }

    public void setOnClickAddUserButtonListener(MainPresenter.AddUserInterface addUserInterface) {
        this.addUserInterface = addUserInterface;
    }

    public UserContentView getUserContentView() {
        return userContentView;
    }

    private void initElements() {
        addUserButton = new Button("Add user");
    }

    private void initListeners() {
        addUserButton.addClickListener(event -> addUserInterface.create());
    }

    private void buildLayout() {
        addComponents(addUserButton, userContentView);
        setComponentAlignment(addUserButton, Alignment.BOTTOM_CENTER);
    }
}
