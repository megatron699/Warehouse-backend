package ru.ssau.labs.toolwarehousebackend.dto;

import lombok.Data;

import java.util.List;

@Data
public class AuthenticatedUserDto {

    private String accessToken;
    private String username;
    private List<String> roles;
}
