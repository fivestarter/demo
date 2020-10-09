package ru.fivestarter.demo.main.content;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.fivestarter.demo.dao.User;
import ru.fivestarter.demo.dao.UserRepository;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class UserContentPresenter {
    private final UserContentView userContentView;
    private final UserRepository userRepository;

    @Autowired
    public UserContentPresenter(UserContentView userContentView,
                                UserRepository userRepository) {
        this.userContentView = userContentView;
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init() {
        fillData();
    }

    private void fillData() {
        List<User> users = userRepository.findAll();
        users.forEach(this::addUser);

    }

    public void addUser(User user) {
        userContentView.addUserRow(user.toStringLabelText());
    }

    public UserContentView getView() {
        return userContentView;
    }

    //fillData для справочных значений, предзаполнение для вьюх
}
