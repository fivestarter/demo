package ru.fivestarter.demo.adminpage.usercreationwindow;

import ru.fivestarter.demo.model.User;
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
public class UserCreationWindowPresenter {

    private final UserCreationWindow window;
    private AddUserListener addUserListener;

    @Autowired
    public UserCreationWindowPresenter(UserCreationWindow userCreationWindow) {
        this.window = userCreationWindow;
    }

    @PostConstruct
    public void init() {
        initListeners();
    }

    private void initListeners() {
        window.getCreateUserButton().addClickListener(event -> createUser());
        window.getCancelButton().addClickListener(event -> closeWindow());
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
        window.getLoginField().clear();
        window.getFirstNameField().clear();
        window.getLastNameField().clear();
        window.getPasswordField().clear();
        window.getBirthDayField().clear();
    }

    private User gatherData() {
        return new User(
                window.getLoginField().getValue(),
                window.getFirstNameField().getValue(),
                window.getLastNameField().getValue(),
                window.getPasswordField().getValue(),
                window.getBirthDayField().getValue());
    }

    private String validate() {
        StringBuilder validationErrors = new StringBuilder();
        if (StringUtils.isEmpty(window.getLoginField().getValue())) {
            validationErrors.append("Login can't be blank.");
            validationErrors.append(StringUtils.LF);
        }
        if (StringUtils.isEmpty(window.getFirstNameField().getValue())) {
            validationErrors.append("First name can't be blank.");
            validationErrors.append(StringUtils.LF);
        }
        if (StringUtils.isEmpty(window.getLastNameField().getValue())) {
            validationErrors.append("Last name can't be blank.");
            validationErrors.append(StringUtils.LF);
        }
        if (Objects.isNull(window.getBirthDayField().getValue())) {
            validationErrors.append("Birth day can't be blank.");
            validationErrors.append(StringUtils.LF);
        }
        if (StringUtils.isEmpty(window.getPasswordField().getValue())) {
            validationErrors.append("Password can't be blank.");
            validationErrors.append(StringUtils.LF);
        }
        return validationErrors.toString();
    }

    private void closeWindow() {
        clearFieldsData();
        window.close();
    }

    public void setCreateUserListener(AddUserListener addUserListener) {
        this.addUserListener = addUserListener;
    }

    public void showWindow() {
        UI.getCurrent().addWindow(window);
    }
}
