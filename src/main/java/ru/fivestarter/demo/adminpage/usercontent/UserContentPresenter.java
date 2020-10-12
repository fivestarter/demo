package ru.fivestarter.demo.adminpage.usercontent;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.fivestarter.demo.model.User;
import ru.fivestarter.demo.service.UserService;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class UserContentPresenter {
    private final UserContentView view;
    private final UserService userService;

    @Autowired
    public UserContentPresenter(UserContentView userContentView, UserService userService) {
        this.view = userContentView;
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        fillData();
    }

    private void fillData() {
        List<User> users = userService.findAllUsers();
        users.forEach(this::addUser);
    }

    public void addUser(User user) {
        view.addUserRow(user.toStringLabelText());
    }

    public UserContentView getView() {
        return view;
    }
}
