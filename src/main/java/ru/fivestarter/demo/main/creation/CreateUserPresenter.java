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
    private final CreateUserView view;
    private final CreateUserWindowPresenter createUserWindowPresenter;

    @Autowired
    public CreateUserPresenter(CreateUserView createUserView,
                               CreateUserWindowPresenter createUserWindowPresenter) {
        this.view = createUserView;
        this.createUserWindowPresenter = createUserWindowPresenter;
    }

    @PostConstruct
    public void init() {
        initListeners();
    }

    private void initListeners() {
        view.getAddUserButton().addClickListener(event -> createUserWindowPresenter.showWindow());
    }

    public void setCreateUserListener(AddUserListener addUserListener) {
        createUserWindowPresenter.setCreateUserListener(addUserListener);
    }

    public CreateUserView getView() {
        return view;
    }
}
