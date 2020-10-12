package ru.fivestarter.demo.dao;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import ru.fivestarter.demo.model.User;

@Component
public class UserRepository {

    public List<User> findAll() {

        User user = new User(
                "johnd",
                "John",
                "Doe",
                "123",
                LocalDate.of(2020, 10, 9));

        User userB = new User(
                "ivan",
                "Ivan",
                "Ivanov",
                "435",
                LocalDate.of(2020, 9, 9));
        return Arrays.asList(user, userB);
    }
}
