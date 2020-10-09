package ru.fivestarter.demo;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

import ru.fivestarter.demo.user.content.UserContentView;

public class MainView extends VerticalLayout {

    private final UserContentView userContentView = new UserContentView();
    //todo should it be here?
    private Button addUserButton;
    private transient AddUserButtonListener addUserButtonListener;

    public MainView() {
        super();
        initElements();
        initListeners();
        buildLayout();
    }

    public void setOnClickAddUserButtonListener(AddUserButtonListener addUserButtonListener) {
        this.addUserButtonListener = addUserButtonListener;
    }

    public UserContentView getUserContentView() {
        return userContentView;
    }

    private void initElements() {
        addUserButton = new Button("Add user");
    }

    private void initListeners() {
        addUserButton.addClickListener(event -> addUserButtonListener.addUser());
    }

    private void buildLayout() {
        addComponents(addUserButton, userContentView);
        setComponentAlignment(addUserButton, Alignment.BOTTOM_CENTER);
    }

    public interface AddUserButtonListener {
        void addUser();
    }
}
