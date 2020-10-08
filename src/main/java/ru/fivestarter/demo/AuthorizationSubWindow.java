package ru.fivestarter.demo;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

public class AuthorizationSubWindow extends Window {
    private final FormLayout form = new FormLayout();
    private final HorizontalLayout buttonsLayout = new HorizontalLayout();
    private final TextField loginField = new TextField("Login");
    private final TextField passwordField = new PasswordField("Password");
    private final Button authorizeButton = new Button("Authorize");
    private final Button cancelButton = new Button("Cancel");

    public AuthorizationSubWindow(String caption) {
        super(caption);
        init();
    }

    protected void init() {
        initForm();

        setContent(form);
        setModal(true);
        setClosable(false);
        setWidth(25, Unit.PERCENTAGE);
    }

    private void initForm() {
        initLoginField();
        form.addComponent(loginField);

        initPasswordField();
        form.addComponent(passwordField);

        initButtonsLayout();
        form.addComponent(buttonsLayout);
    }

    private void initLoginField() {
        loginField.setIcon(VaadinIcons.USER);
        loginField.setRequiredIndicatorVisible(true);
    }

    private void initPasswordField() {
        passwordField.setIcon(VaadinIcons.PASSWORD);
        passwordField.setRequiredIndicatorVisible(true);
    }

    private void initButtonsLayout() {
        initAuthorizeButton();
        initCancelButton();
        buttonsLayout.addComponent(authorizeButton);
        buttonsLayout.addComponent(cancelButton);
    }

    private void initAuthorizeButton() {
        authorizeButton.addClickListener(event ->
                Notification.show("This is the authorize information:",
                        String.format("Login: %s, Password: %s", loginField.getValue(), passwordField.getValue()),
                        Notification.Type.HUMANIZED_MESSAGE));
    }

    private void initCancelButton() {
        cancelButton.addClickListener(event -> close());
    }
}
