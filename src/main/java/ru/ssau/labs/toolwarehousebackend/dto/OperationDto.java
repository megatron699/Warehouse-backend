package ru.ssau.labs.toolwarehousebackend.dto;

import lombok.Getter;
import lombok.Setter;
import ru.ssau.labs.toolwarehousebackend.domain.OperationType;
import ru.ssau.labs.toolwarehousebackend.domain.Tool;
import ru.ssau.labs.toolwarehousebackend.domain.ToolWarehouse;
import ru.ssau.labs.toolwarehousebackend.domain.Employee;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class OperationDto {
    private Long id;
    @NotNull
    private Date operationDate;
    @NotNull
    private int amount;
    @NotNull
    private OperationType operationType;
    @NotNull
    private ToolWarehouse toolWarehouse;
    @NotNull
    private Tool tool;
    @NotNull
    private Employee employee;
}
