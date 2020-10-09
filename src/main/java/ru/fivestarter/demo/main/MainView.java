package ru.fivestarter.demo.main;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

import ru.fivestarter.demo.user.content.UserContentView;

@UIScope
@SpringView()
public class MainView extends VerticalLayout implements View {

    private final UserContentView userContentView;
    //todo should it be here?
    private Button addUserButton;
    private transient AddUserButtonListener addUserButtonListener;

    @Autowired
    public MainView(UserContentView userContentView) {
        super();
        this.userContentView = userContentView;
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
