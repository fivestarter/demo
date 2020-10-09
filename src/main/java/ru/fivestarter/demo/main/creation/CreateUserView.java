package ru.fivestarter.demo.main.creation;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CreateUserView extends VerticalLayout {
    private Button addUserButton;

    @PostConstruct
    public void init() {
        initElements();
        buildLayout();
    }

    private void initElements() {
        addUserButton = new Button("Add user");
    }

    private void buildLayout() {
        addComponent(new Label("Блок добавления пользователей"));
        addComponent(addUserButton);
    }

    public Button getAddUserButton() {
        return addUserButton;
    }
}
