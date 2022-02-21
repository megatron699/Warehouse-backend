package ru.ssau.labs.toolwarehousebackend.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.ssau.labs.toolwarehousebackend.domain.Operation;
import ru.ssau.labs.toolwarehousebackend.dto.OperationDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-15T14:59:16+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class OperationMapperImpl implements OperationMapper {

    @Override
    public Operation toEntity(OperationDto dto) {
        if ( dto == null ) {
            return null;
        }

        Operation operation = new Operation();

        operation.setId( dto.getId() );
        operation.setAmount( dto.getAmount() );
        operation.setOperationType( dto.getOperationType() );
        operation.setToolWarehouse( dto.getToolWarehouse() );
        operation.setTool( dto.getTool() );
        operation.setEmployee( dto.getEmployee() );

        return operation;
    }

    @Override
    public OperationDto toDto(Operation entity) {
        if ( entity == null ) {
            return null;
        }

        OperationDto operationDto = new OperationDto();

        operationDto.setId( entity.getId() );
        operationDto.setAmount( entity.getAmount() );
        operationDto.setOperationType( entity.getOperationType() );
        operationDto.setToolWarehouse( entity.getToolWarehouse() );
        operationDto.setTool( entity.getTool() );
        operationDto.setEmployee( entity.getEmployee() );

        return operationDto;
    }
}
