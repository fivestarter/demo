package ru.fivestarter.demo.main.creation;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CreateUserPresenter {

    //rename to view
    private final CreateUserView createUserView;
    private final CreateUserWindowPresenter createUserWindowPresenter;

    @Autowired
    public CreateUserPresenter(CreateUserView createUserView,
                               CreateUserWindowPresenter createUserWindowPresenter) {
        this.createUserView = createUserView;
        this.createUserWindowPresenter = createUserWindowPresenter;
    }

    @PostConstruct
    public void init() {
        initListeners();
    }

    private void initListeners() {
        createUserView.getAddUserButton().addClickListener(event -> createUserWindowPresenter.showWindow());
    }

    public void setCreateUserListener(AddUserListener addUserListener) {
        createUserWindowPresenter.setCreateUserListener(addUserListener);
    }

    public CreateUserView getCreateUserView() {
        return createUserView;
    }
}
