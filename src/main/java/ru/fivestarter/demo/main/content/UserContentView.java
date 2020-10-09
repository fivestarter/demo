package ru.fivestarter.demo.main.content;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import ru.fivestarter.demo.dao.UserRepository;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class UserContentView extends VerticalLayout {

    private final VerticalLayout containerView = new VerticalLayout();
    private final UserRepository userRepository;

    @Autowired
    public UserContentView(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init() {
        //todo initElements
        buildLayout();
    }

    private void buildLayout() {
        addComponents(new Label("Блок отображения юзеров"), containerView);
    }

    public VerticalLayout getContainerView() {
        return containerView;
    }
    //todo
    //getView

    public void addUserRow(String userData) {
        containerView.addComponent(new Label(userData));
    }

}
