package ru.ssau.labs.toolwarehousebackend.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.ssau.labs.toolwarehousebackend.domain.OperationType;
import ru.ssau.labs.toolwarehousebackend.dto.OperationTypeDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-18T14:03:53+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class OperationTypeMapperImpl implements OperationTypeMapper {

    @Override
    public OperationType toEntity(OperationTypeDto dto) {
        if ( dto == null ) {
            return null;
        }

        OperationType operationType = new OperationType();

        operationType.setId( dto.getId() );
        operationType.setOperationType( dto.getOperationType() );

        return operationType;
    }

    @Override
    public OperationTypeDto toDto(OperationType entity) {
        if ( entity == null ) {
            return null;
        }

        OperationTypeDto operationTypeDto = new OperationTypeDto();

        operationTypeDto.setId( entity.getId() );
        operationTypeDto.setOperationType( entity.getOperationType() );

        return operationTypeDto;
    }
}
