package ru.ssau.labs.toolwarehousebackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ssau.labs.toolwarehousebackend.dao.UserDao;
import ru.ssau.labs.toolwarehousebackend.domain.User;

@Service
@RequiredArgsConstructor
public class UserDetailsService {
    private final UserDao userDao;

    public UserDetails loadUserByUsername(String login, String password) {
        User user = userDao.findByLoginAndPassword(login, password).orElse(null);
                //.orElseThrow(() -> null);
        return user == null
                ? null
                : UserDetails.fromUser(user);
    }
}
