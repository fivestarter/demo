package ru.fivestarter.demo.adminpage.usercreation;

import ru.fivestarter.demo.adminpage.usercreationwindow.AddUserListener;
import ru.fivestarter.demo.adminpage.usercreationwindow.UserCreationWindowPresenter;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class UserCreationPresenter {

    //rename to view
    private final UserCreationView view;
    private final UserCreationWindowPresenter userCreationWindowPresenter;

    @Autowired
    public UserCreationPresenter(UserCreationView userCreationView,
                                 UserCreationWindowPresenter userCreationWindowPresenter) {
        this.view = userCreationView;
        this.userCreationWindowPresenter = userCreationWindowPresenter;
    }

    @PostConstruct
    public void init() {
        initListeners();
    }

    private void initListeners() {
        view.getAddUserButton().addClickListener(event -> userCreationWindowPresenter.showWindow());
    }

    public void setCreateUserListener(AddUserListener addUserListener) {
        userCreationWindowPresenter.setCreateUserListener(addUserListener);
    }

    public UserCreationView getView() {
        return view;
    }
}
