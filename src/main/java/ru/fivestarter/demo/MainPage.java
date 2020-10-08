package ru.fivestarter.demo;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@SpringUI
@Theme("valo")
public class MainPage extends UI {

    private final VerticalLayout verticalLayout = new VerticalLayout();
    private final Button button = new Button("Click Me");

    @Override
    protected void init(VaadinRequest request) {
        verticalLayout.addComponent(button);
        verticalLayout.setComponentAlignment(button, Alignment.BOTTOM_CENTER);
        setContent(verticalLayout);

        Window subWindow = new AuthorizationSubWindow("Authorization window");
        subWindow.center();

        button.addClickListener(event -> UI.getCurrent().addWindow(subWindow));
    }
}
