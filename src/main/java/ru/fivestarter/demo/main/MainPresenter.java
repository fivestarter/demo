package ru.fivestarter.demo.main;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.ui.VerticalLayout;

import ru.fivestarter.demo.main.content.UserContentPresenter;
import ru.fivestarter.demo.main.creation.CreateUserPresenter;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class MainPresenter {

    private final CreateUserPresenter createUserPresenter;
    private final UserContentPresenter userContentPresenter;
    private VerticalLayout view;

    @Autowired
    public MainPresenter(CreateUserPresenter createUserPresenter, UserContentPresenter userContentPresenter) {
        this.createUserPresenter = createUserPresenter;
        this.userContentPresenter = userContentPresenter;
    }

    @PostConstruct
    public void init() {
        view = new VerticalLayout();
        initListeners();

        view.addComponents(createUserPresenter.getView(), userContentPresenter.getView());
    }

    private void initListeners() {
        createUserPresenter.setCreateUserListener(userContentPresenter::addUser);
    }

    public VerticalLayout getView() {
        return view;
    }
}
