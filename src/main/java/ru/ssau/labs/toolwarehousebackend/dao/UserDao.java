package ru.ssau.labs.toolwarehousebackend.dao;

import org.springframework.data.repository.CrudRepository;
import ru.ssau.labs.toolwarehousebackend.domain.User;

import java.util.Optional;

public interface UserDao extends CrudRepository<User, Long> {
    Optional<User> findByLogin(String login);
}
