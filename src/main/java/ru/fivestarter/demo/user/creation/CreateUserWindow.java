package ru.fivestarter.demo.user.creation;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.Resource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import ru.fivestarter.demo.user.User;

public class CreateUserWindow extends Window {

    private TextField loginField;
    private TextField firstNameField;
    private TextField lastNameField;
    private DateField birthDayField;
    private TextField passwordField;
    private Button authorizeButton;
    private Button cancelButton;
    private CreateUserPresenter.UserInterface userInterface;

    public CreateUserWindow() {
        super("Authorization window");
        center();
        setModal(true);
        setClosable(false);
        setWidth(25, Unit.PERCENTAGE);

        initElements();
        initListeners();
        buildLayout();
    }

    public void setUserInterface(CreateUserPresenter.UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    private void initElements() {
        loginField = initFormField("Login", VaadinIcons.USER);
        firstNameField = initFormField("First name", VaadinIcons.USER);
        lastNameField = initFormField("Last name", VaadinIcons.USER);
        birthDayField = initBirthDayField();
        passwordField = initFormField("Password", VaadinIcons.PASSWORD);

        authorizeButton = new Button("Authorize");
        cancelButton = new Button("Cancel");
    }

    private DateField initBirthDayField() {
        DateField dateField = new DateField("Birth day");
        dateField.setIcon(VaadinIcons.DATE_INPUT);
        dateField.setRequiredIndicatorVisible(true);
        return dateField;
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

    public void authorize() {
        //if (validate());
        try {
            //validate2();
            User user = gatherData();
//            Notification.show("This is the authorize information:",
//                    String.format("Login: %s, Password: %s", loginField.getValue(), passwordField.getValue()),
//                    Notification.Type.HUMANIZED_MESSAGE);
            userInterface.getUser(user);
            close();
        } catch (ValueException e) {
            Notification.show("This is the authorize information:",
                    e.getMessage(),
                    Notification.Type.HUMANIZED_MESSAGE);
        }
    }

    private User gatherData() {
        return new User(
                loginField.getValue(),
                firstNameField.getValue(),
                lastNameField.getValue(),
                passwordField.getValue(),
                birthDayField.getValue());

    }

//    private String validate() {
//        StringBuilder messages;
//        if (StringUtils.isEmpty(loginField.getValue()) {
//
//        }
//    }
//
//    private String validate2() {
//        StringBuilder messages = new StringBuilder();
//        if (StringUtils.isEmpty(loginField.getValue()) {
//
//        }
//        if (StringUtils.isNotEmpty(messages.toString())) {
//            throw new ValueException("" + messages.toString());
//        }
//    }

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
        authorizationForm.addComponents(loginField, firstNameField, lastNameField, birthDayField, passwordField);
        return authorizationForm;
    }

}
