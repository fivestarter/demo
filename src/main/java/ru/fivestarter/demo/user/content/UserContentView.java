package ru.fivestarter.demo.user.content;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import ru.fivestarter.demo.user.dao.UserRepository;

@UIScope
@SpringView(name = "content")
public class UserContentView extends VerticalLayout implements View {

    private final VerticalLayout containerView = new VerticalLayout();
    private final UserRepository userRepository;

    @Autowired
    public UserContentView(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
        buildLayout();
    }

    private void buildLayout() {
        addComponents(new Label("User list"), containerView);
        userRepository.findAll().forEach(user -> containerView.addComponent(new Label(user.toStringLabelText())));
    }

    public VerticalLayout getContainerView() {
        return containerView;
    }
}
