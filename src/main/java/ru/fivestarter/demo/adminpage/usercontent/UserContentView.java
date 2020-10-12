package ru.fivestarter.demo.adminpage.usercontent;

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

    @PostConstruct
    public void init() {
        initElements();
        initElements();
        buildLayout();
    }

    private void initElements() {
        containerView = new VerticalLayout();
    }

    private void buildLayout() {
        addComponents(new Label("User display block"), containerView);
    }

    public void addUserRow(String userData) {
        containerView.addComponent(new Label(userData));
    }

}
