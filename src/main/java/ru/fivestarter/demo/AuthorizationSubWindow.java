package ru.fivestarter.demo;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.Resource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
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
        loginField = initFormField("Login", VaadinIcons.USER);
        passwordField = initFormField("Password", VaadinIcons.PASSWORD);

        authorizeButton = new Button("Authorize");
        cancelButton = new Button("Cancel");
    }

    private TextField initFormField(String caption, Resource icon) {
        final TextField textField = new TextField(caption);
        textField.setIcon(icon);
        textField.setRequiredIndicatorVisible(true);
        return textField;
    }

    private void initListeners() {
        authorizeButton.addClickListener(event -> authorize());
        cancelButton.addClickListener(event -> closeWindow());
    }

    private void closeWindow() {
        loginField.clear();
        passwordField.clear();
        close();
    }

    private void authorize() {
        Notification.show("This is the authorize information:",
                String.format("Login: %s, Password: %s", loginField.getValue(), passwordField.getValue()),
                Notification.Type.HUMANIZED_MESSAGE);
    }

    private void buildLayout() {
        final VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setDefaultComponentAlignment(Alignment.BOTTOM_CENTER);

        mainLayout.addComponents(
                buildAuthorizationForm(),
                new HorizontalLayout(authorizeButton, cancelButton));

        setContent(mainLayout);
    }

    private FormLayout buildAuthorizationForm() {
        final FormLayout authorizationForm = new FormLayout();
        authorizationForm.setWidthUndefined();
        authorizationForm.addComponents(loginField, passwordField);
        return authorizationForm;
    }

}
