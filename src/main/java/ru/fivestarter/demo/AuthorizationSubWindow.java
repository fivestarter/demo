package ru.fivestarter.demo;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class AuthorizationSubWindow extends Window {

    private TextField loginField;
    private TextField passwordField;
    private Button authorizeButton;
    private Button cancelButton;

    public AuthorizationSubWindow() {
        super("Authorization window");
        center();
        setModal(true);
        setClosable(false);
        setWidth(25, Unit.PERCENTAGE);

        initElements();
        initListeners();
        buildLayout();
    }

    private void initElements() {
        loginField = new TextField("Login");
        loginField.setIcon(VaadinIcons.USER);
        loginField.setRequiredIndicatorVisible(true);

        passwordField = new PasswordField("Password");
        passwordField.setIcon(VaadinIcons.PASSWORD);
        passwordField.setRequiredIndicatorVisible(true);

        authorizeButton = new Button("Authorize");
        cancelButton = new Button("Cancel");
    }

    private void initListeners() {
        authorizeButton.addClickListener(event ->
                Notification.show("This is the authorize information:",
                        String.format("Login: %s, Password: %s", loginField.getValue(), passwordField.getValue()),
                        Notification.Type.HUMANIZED_MESSAGE));

        cancelButton.addClickListener(event -> {
            loginField.clear();
            passwordField.clear();
            close();
        });
    }

    private void buildLayout() {
        final VerticalLayout mainLayout = new VerticalLayout();
        final FormLayout authorizationForm = new FormLayout();
        final HorizontalLayout buttonsLayout = new HorizontalLayout();

        mainLayout.addComponents(authorizationForm, buttonsLayout);
        authorizationForm.addComponents(loginField, passwordField);
        buttonsLayout.addComponents(authorizeButton, cancelButton);
        setContent(mainLayout);
    }
}
