package ru.ssau.labs.toolwarehousebackend.dto;

import lombok.Getter;
import lombok.Setter;
import ru.ssau.labs.toolwarehousebackend.domain.Operation;
import ru.ssau.labs.toolwarehousebackend.domain.ToolWarehouse;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class EmployeeDto {
    private Long id;
    @NotBlank(message = "Введите фамилию")
    private String lastName;
    @NotBlank(message = "Введите имя")
    private String firstName;
    private String patronymic;
    @NotBlank(message = "Введите должность")
    private String position;
    @NotNull
    private ToolWarehouse toolWarehouse;
    private Set<Operation> operations = new HashSet<>();
}
