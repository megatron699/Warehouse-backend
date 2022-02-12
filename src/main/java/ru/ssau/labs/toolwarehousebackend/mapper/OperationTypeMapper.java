package ru.ssau.labs.toolwarehousebackend.mapper;

import org.mapstruct.Mapper;
import ru.ssau.labs.toolwarehousebackend.domain.Operation;
import ru.ssau.labs.toolwarehousebackend.domain.OperationType;
import ru.ssau.labs.toolwarehousebackend.dto.OperationTypeDto;

@Mapper(componentModel = "spring")
public interface OperationTypeMapper {

    OperationType toEntity(OperationTypeDto dto);

    OperationTypeDto toDto(OperationType entity);


}
