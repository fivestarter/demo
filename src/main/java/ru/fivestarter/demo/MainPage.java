package ru.fivestarter.demo;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI
@Theme("valo")
public class MainPage extends UI {


    private Button clickMeButton;

    @Override
    protected void init(VaadinRequest request) {
        initElements();
        initListeners();
        buildLayout();
    }

    private void initElements() {
        clickMeButton = new Button("Click Me");
    }

    private void initListeners() {
        clickMeButton.addClickListener(event -> UI.getCurrent().addWindow(new AuthorizationSubWindow()));
    }

    private void buildLayout() {
        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.addComponent(clickMeButton);
        mainLayout.setComponentAlignment(clickMeButton, Alignment.BOTTOM_CENTER);
        setContent(mainLayout);
    }

}
