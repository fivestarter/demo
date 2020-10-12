package ru.fivestarter.demo.adminpage;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

@SpringUI()
@Theme("valo")
@Title(value = "Admin Page")
public class AdminPage extends UI {

    private final AdminPresenter adminPresenter;

    @Autowired
    public AdminPage(AdminPresenter adminPresenter) {
        this.adminPresenter = adminPresenter;
    }

    @Override
    protected void init(VaadinRequest request) {
        setContent(adminPresenter.getView());
    }
}
