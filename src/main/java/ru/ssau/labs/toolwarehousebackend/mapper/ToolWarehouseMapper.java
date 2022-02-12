package ru.ssau.labs.toolwarehousebackend.mapper;

import org.mapstruct.Mapper;
import ru.ssau.labs.toolwarehousebackend.domain.ToolWarehouse;
import ru.ssau.labs.toolwarehousebackend.dto.ToolWarehouseDto;

@Mapper(componentModel = "spring")
public interface ToolWarehouseMapper {

    ToolWarehouse toEntity(ToolWarehouseDto dto);

    ToolWarehouseDto toDto(ToolWarehouse entity);
}
