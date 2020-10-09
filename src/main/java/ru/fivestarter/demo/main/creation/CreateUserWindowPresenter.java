package ru.fivestarter.demo.main.creation;

import ru.fivestarter.demo.dao.User;
import java.util.Objects;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CreateUserWindowPresenter {

    private final CreateUserWindow createUserWindow;
    private AddUserListener addUserListener;

    @Autowired
    public CreateUserWindowPresenter(CreateUserWindow createUserWindow) {
        this.createUserWindow = createUserWindow;
    }

    @PostConstruct
    public void init() {
        initListeners();
    }

    private void initListeners() {
        createUserWindow.getCreateUserButton().addClickListener(event -> createUser());
        createUserWindow.getCancelButton().addClickListener(event -> closeWindow());
    }

    public void createUser() {
        String validationErrors = validate();
        if (StringUtils.isBlank(validationErrors)) {
            User user = gatherData();
            closeWindow();

            if (addUserListener != null) {
                addUserListener.addUser(user);
            }
        } else {
            Notification.show("There were problems with the following fields:",
                    validationErrors,
                    Notification.Type.ERROR_MESSAGE);
        }

    }

    private void clearFieldsData() {
        createUserWindow.getLoginField().clear();
        createUserWindow.getFirstNameField().clear();
        createUserWindow.getLastNameField().clear();
        createUserWindow.getPasswordField().clear();
        createUserWindow.getBirthDayField().clear();
    }

    private User gatherData() {
        return new User(
                createUserWindow.getLoginField().getValue(),
                createUserWindow.getFirstNameField().getValue(),
                createUserWindow.getLastNameField().getValue(),
                createUserWindow.getPasswordField().getValue(),
                createUserWindow.getBirthDayField().getValue());
    }

    private String validate() {
        StringBuilder validationErrors = new StringBuilder();
        if (StringUtils.isEmpty(createUserWindow.getLoginField().getValue())) {
            validationErrors.append("Login can't be blank.");
            validationErrors.append(StringUtils.LF);
        }
        if (StringUtils.isEmpty(createUserWindow.getFirstNameField().getValue())) {
            validationErrors.append("First name can't be blank.");
            validationErrors.append(StringUtils.LF);
        }
        if (StringUtils.isEmpty(createUserWindow.getLastNameField().getValue())) {
            validationErrors.append("Last name can't be blank.");
            validationErrors.append(StringUtils.LF);
        }
        if (Objects.isNull(createUserWindow.getBirthDayField().getValue())) {
            validationErrors.append("Birth day can't be blank.");
            validationErrors.append(StringUtils.LF);
        }
        if (StringUtils.isEmpty(createUserWindow.getPasswordField().getValue())) {
            validationErrors.append("Password can't be blank.");
            validationErrors.append(StringUtils.LF);
        }
        return validationErrors.toString();
    }

    private void closeWindow() {
        clearFieldsData();
        createUserWindow.close();
    }

    public void setCreateUserListener(AddUserListener addUserListener) {
        this.addUserListener = addUserListener;
    }

    public void showWindow() {
        UI.getCurrent().addWindow(createUserWindow);
    }
}
