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

    @PostConstruct
    public void init() {
        initElements();
        buildLayout();
    }

    private void initElements() {
        containerView = new VerticalLayout();
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
