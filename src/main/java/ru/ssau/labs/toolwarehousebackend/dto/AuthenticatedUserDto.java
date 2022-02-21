package ru.ssau.labs.toolwarehousebackend.dto;

import lombok.Data;
import ru.ssau.labs.toolwarehousebackend.enums.RoleEnum;

import java.util.List;

@Data
public class AuthenticatedUserDto {

    private String username;
    private RoleEnum role;
}
