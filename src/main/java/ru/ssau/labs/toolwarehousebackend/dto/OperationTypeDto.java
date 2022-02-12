package ru.ssau.labs.toolwarehousebackend.dto;

import lombok.Getter;
import lombok.Setter;
import ru.ssau.labs.toolwarehousebackend.domain.Operation;
import ru.ssau.labs.toolwarehousebackend.enums.OperationTypeEnum;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class OperationTypeDto {
    private Long id;
    @NotNull
    private OperationTypeEnum operationType;
    private Set<Operation> operations = new HashSet<>();
}
