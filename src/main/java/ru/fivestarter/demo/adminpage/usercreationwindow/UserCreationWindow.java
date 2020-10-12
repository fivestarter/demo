package ru.fivestarter.demo.adminpage.usercreationwindow;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class UserCreationWindow extends Window {

    private TextField loginField;
    private TextField firstNameField;
    private TextField lastNameField;
    private DateField birthDayField;
    private TextField passwordField;

    private Button createUserButton;
    private Button cancelButton;

    @PostConstruct
    public void init() {
        setCaption("User creation window");
        center();
        setModal(true);
        setClosable(false);
        setWidth(25, Unit.PERCENTAGE);

        initElements();
        buildLayout();
    }

    private void initElements() {
        loginField = initFormField("Login");
        firstNameField = initFormField("First name");
        lastNameField = initFormField("Last name");
        birthDayField = initBirthDayField();
        passwordField = initPasswordField();

        createUserButton = new Button("Create");
        cancelButton = new Button("Cancel");
    }

    private PasswordField initPasswordField() {
        PasswordField field = new PasswordField("Password");
        field.setIcon(VaadinIcons.PASSWORD);
        field.setRequiredIndicatorVisible(true);
        return field;
    }

    private DateField initBirthDayField() {
        final DateField dateField = new DateField("Birth day");
        dateField.setIcon(VaadinIcons.DATE_INPUT);
        dateField.setRequiredIndicatorVisible(true);
        return dateField;
    }

    private TextField initFormField(String caption) {
        final TextField textField = new TextField(caption);
        textField.setIcon(VaadinIcons.USER);
        textField.setRequiredIndicatorVisible(true);
        return textField;
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
        authorizationForm.addComponents(
                loginField,
                firstNameField,
                lastNameField,
                birthDayField,
                passwordField);
        return authorizationForm;
    }

    TextField getLoginField() {
        return loginField;
    }

    TextField getFirstNameField() {
        return firstNameField;
    }

    TextField getLastNameField() {
        return lastNameField;
    }

    DateField getBirthDayField() {
        return birthDayField;
    }

    TextField getPasswordField() {
        return passwordField;
    }

    Button getCreateUserButton() {
        return createUserButton;
    }

    Button getCancelButton() {
        return cancelButton;
    }
}
