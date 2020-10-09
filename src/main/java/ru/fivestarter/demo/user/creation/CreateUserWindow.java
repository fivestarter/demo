package ru.fivestarter.demo.user.creation;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

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

import ru.fivestarter.demo.user.dao.User;

public class CreateUserWindow extends Window {

    private TextField loginField;
    private TextField firstNameField;
    private TextField lastNameField;
    private DateField birthDayField;
    private TextField passwordField;
    private Button createUserButton;
    private Button cancelButton;
    private transient CreateUserButtonListener createUserButtonListener;

    public CreateUserWindow() {
        super("Create user window");
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
        firstNameField = initFormField("First name", VaadinIcons.USER);
        lastNameField = initFormField("Last name", VaadinIcons.USER);
        birthDayField = initBirthDayField();
        passwordField = initFormField("Password", VaadinIcons.PASSWORD);

        createUserButton = new Button("Create");
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
        createUserButton.addClickListener(event -> authorize());
        cancelButton.addClickListener(event -> closeWindow());
    }

    private void closeWindow() {
        clearFieldsData();
        close();
    }

    public void authorize() {
        String validationErrors = validate();
        if (StringUtils.isBlank(validationErrors)) {
            User user = gatherData();
            createUserButtonListener.createUser(user);
            clearFieldsData();
            close();
        } else {
            Notification.show("There were problems with the following fields:",
                    validationErrors,
                    Notification.Type.ERROR_MESSAGE);
        }

    }

    private void clearFieldsData() {
        loginField.clear();
        firstNameField.clear();
        lastNameField.clear();
        passwordField.clear();
        birthDayField.clear();
    }

    private User gatherData() {
        return new User(
                loginField.getValue(),
                firstNameField.getValue(),
                lastNameField.getValue(),
                passwordField.getValue(),
                birthDayField.getValue());
    }

    private String validate() {
        StringBuilder validationErrors = new StringBuilder();
        if (StringUtils.isEmpty(loginField.getValue())) {
            validationErrors.append("Login can't be blank.");
            validationErrors.append(StringUtils.LF);
        }
        if (StringUtils.isEmpty(firstNameField.getValue())) {
            validationErrors.append("First name can't be blank.");
            validationErrors.append(StringUtils.LF);
        }
        if (StringUtils.isEmpty(lastNameField.getValue())) {
            validationErrors.append("Last name can't be blank.");
            validationErrors.append(StringUtils.LF);
        }
        if (Objects.isNull(birthDayField.getValue())) {
            validationErrors.append("Birth day can't be blank.");
            validationErrors.append(StringUtils.LF);
        }
        if (StringUtils.isEmpty(passwordField.getValue())) {
            validationErrors.append("Password can't be blank.");
            validationErrors.append(StringUtils.LF);
        }
        return validationErrors.toString();
    }

    private void buildLayout() {
        final VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setDefaultComponentAlignment(Alignment.BOTTOM_CENTER);

        mainLayout.addComponents(
                buildAuthorizationForm(),
                new HorizontalLayout(createUserButton, cancelButton));

        setContent(mainLayout);
    }

    private FormLayout buildAuthorizationForm() {
        final FormLayout authorizationForm = new FormLayout();
        authorizationForm.setWidthUndefined();
        authorizationForm.addComponents(loginField, firstNameField, lastNameField, birthDayField, passwordField);
        return authorizationForm;
    }

    public void setOnClickCreateUserButtonListener(CreateUserButtonListener createUserButtonListener) {
        this.createUserButtonListener = createUserButtonListener;
    }

    public interface CreateUserButtonListener {
        void createUser(User user);
    }

}
