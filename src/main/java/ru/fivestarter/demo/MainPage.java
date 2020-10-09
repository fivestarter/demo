package ru.fivestarter.demo;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

import ru.fivestarter.demo.main.MainPresenter;

@SpringUI()
@Theme("valo")
@Title(value = "Main Page")
public class MainPage extends UI {

    private final MainPresenter mainPresenter;

    @Autowired
    public MainPage(MainPresenter mainPresenter) {
        this.mainPresenter = mainPresenter;
    }

    @Override
    protected void init(VaadinRequest request) {
        setContent(mainPresenter.getView());
    }
}
