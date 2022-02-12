package ru.ssau.labs.toolwarehousebackend.dto;

import lombok.Getter;
import lombok.Setter;
import ru.ssau.labs.toolwarehousebackend.domain.Operation;
import ru.ssau.labs.toolwarehousebackend.domain.Employee;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class ToolWarehouseDto {
    private Long id;
    @NotBlank
    private String warehouseName;
    private Set<Employee> employees = new HashSet<>();
    private Set<Operation> operations = new HashSet<>();
}
