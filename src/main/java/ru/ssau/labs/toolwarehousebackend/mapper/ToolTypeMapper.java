package ru.ssau.labs.toolwarehousebackend.mapper;

import org.mapstruct.Mapper;
import ru.ssau.labs.toolwarehousebackend.domain.ToolType;
import ru.ssau.labs.toolwarehousebackend.dto.ToolTypeDto;

@Mapper(componentModel = "spring")
public interface ToolTypeMapper {

    ToolType toEntity(ToolTypeDto dto);

    ToolTypeDto toDto(ToolType entity);
}
