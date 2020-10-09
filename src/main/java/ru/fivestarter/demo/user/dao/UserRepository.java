package ru.fivestarter.demo.user.dao;

import java.time.LocalDate;
import java.util.Collections;

import org.springframework.stereotype.Component;

@Component
public class UserRepository {
    Iterable<User> findAll() {
        User user = new User(
                "johnd",
                "John",
                "Doe",
                "123",
                LocalDate.of(2020, 10, 9));
        return Collections.singletonList(user);
    }
}
