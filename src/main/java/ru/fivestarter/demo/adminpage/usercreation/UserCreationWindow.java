package ru.fivestarter.demo.adminpage.usercreation;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.Resource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
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
        setCaption("Create user window");
        center();
        setModal(true);
        setClosable(false);
        setWidth(25, Unit.PERCENTAGE);

        initElements();
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

    public TextField getLoginField() {
        return loginField;
    }

    public TextField getFirstNameField() {
        return firstNameField;
    }

    public TextField getLastNameField() {
        return lastNameField;
    }

    public DateField getBirthDayField() {
        return birthDayField;
    }

    public TextField getPasswordField() {
        return passwordField;
    }

    public Button getCreateUserButton() {
        return createUserButton;
    }

    public Button getCancelButton() {
        return cancelButton;
    }
}
