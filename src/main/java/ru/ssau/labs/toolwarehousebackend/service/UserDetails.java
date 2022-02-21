package ru.ssau.labs.toolwarehousebackend.service;

import ru.ssau.labs.toolwarehousebackend.domain.User;
import ru.ssau.labs.toolwarehousebackend.enums.RoleEnum;

public class UserDetails {
    private Long id;
    private String login;
    private String password;
    private RoleEnum role;

    public UserDetails(Long id, String login, String password, RoleEnum role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public static UserDetails fromUser(User user) {
        return new UserDetails(user.getId(), user.getLogin(), user.getPassword(),
                user.getRole());
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return login;
    }

    public RoleEnum getRole() { return role; }
}
