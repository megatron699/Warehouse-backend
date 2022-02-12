package ru.ssau.labs.toolwarehousebackend.dto;

import lombok.Getter;
import lombok.Setter;
import ru.ssau.labs.toolwarehousebackend.domain.Operation;
import ru.ssau.labs.toolwarehousebackend.domain.ToolType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class ToolDto {
    private Long id;
    @NotBlank
    private String toolName;
    private String manufacturer;
    @NotNull
    private ToolType toolType;
    /*private Set<Operation> operations = new HashSet<>();*/
}
