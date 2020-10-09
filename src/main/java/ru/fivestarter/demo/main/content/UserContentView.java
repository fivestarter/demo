package ru.fivestarter.demo.main.content;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class UserContentView extends VerticalLayout {

    private VerticalLayout containerView;
    private Label userDisplayLabel;

    @PostConstruct
    public void init() {
        initElements();
        initElements();
        buildLayout();
    }

    private void initElements() {
        userDisplayLabel = new Label("User display block");
        containerView = new VerticalLayout();
    }

    private void buildLayout() {
        addComponents(userDisplayLabel, containerView);
    }

    public VerticalLayout getView() {
        return containerView;
    }

    public void addUserRow(String userData) {
        containerView.addComponent(new Label(userData));
    }

}
