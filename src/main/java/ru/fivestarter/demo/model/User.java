package ru.fivestarter.demo.model;

import java.time.LocalDate;

import org.apache.commons.lang3.StringUtils;

public class User {
    private String login;
    private String firstName;
    private String lastName;
    private String password;
    private LocalDate birthdate;

    public User(String login, String firstName, String lastName, String password, LocalDate birthdate) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.birthdate = birthdate;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String toStringLabelText() {
        return getLogin() + StringUtils.SPACE
                + getFirstName() + StringUtils.SPACE
                + getLastName() + StringUtils.SPACE
                + getBirthdate();
    }
}
