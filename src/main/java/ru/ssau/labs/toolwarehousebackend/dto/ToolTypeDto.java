package ru.ssau.labs.toolwarehousebackend.dto;

import lombok.Getter;
import lombok.Setter;
import ru.ssau.labs.toolwarehousebackend.domain.Tool;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class ToolTypeDto {
    private Long id;
    @NotBlank
    private String toolType;
  //  private Set<Tool> tools = new HashSet<>();
}
