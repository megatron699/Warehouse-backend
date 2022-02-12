package ru.ssau.labs.toolwarehousebackend.mapper;

import org.mapstruct.Mapper;
import ru.ssau.labs.toolwarehousebackend.domain.Tool;
import ru.ssau.labs.toolwarehousebackend.dto.ToolDto;

@Mapper(componentModel = "spring")
public interface ToolMapper {

    Tool toEntity(ToolDto dto);

    ToolDto toDto(Tool entity);
}
