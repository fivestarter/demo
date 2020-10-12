package ru.fivestarter.demo.main;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.ui.VerticalLayout;

import ru.fivestarter.demo.main.content.UserContentPresenter;
import ru.fivestarter.demo.main.usercreation.UserCreationPresenter;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class MainPresenter {

    private final UserCreationPresenter userCreationPresenter;
    private final UserContentPresenter userContentPresenter;
    private VerticalLayout view;

    @Autowired
    public MainPresenter(UserCreationPresenter userCreationPresenter, UserContentPresenter userContentPresenter) {
        this.userCreationPresenter = userCreationPresenter;
        this.userContentPresenter = userContentPresenter;
    }

    @PostConstruct
    public void init() {
        view = new VerticalLayout();
        initListeners();

        view.addComponents(userCreationPresenter.getView(), userContentPresenter.getView());
    }

    private void initListeners() {
        userCreationPresenter.setCreateUserListener(userContentPresenter::addUser);
    }

    public VerticalLayout getView() {
        return view;
    }
}
