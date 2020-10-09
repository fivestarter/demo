package ru.fivestarter.demo.dao;

import ru.fivestarter.demo.model.User;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserRepository {

    public List<User> findAll() {
        User user = new User(
                "johnd",
                "John",
                "Doe",
                "123",
                LocalDate.of(2020, 10, 9));
        return Collections.singletonList(user);
    }
}
