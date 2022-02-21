package ru.ssau.labs.toolwarehousebackend.mapper;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.ssau.labs.toolwarehousebackend.domain.Employee;
import ru.ssau.labs.toolwarehousebackend.domain.Operation;
import ru.ssau.labs.toolwarehousebackend.domain.ToolWarehouse;
import ru.ssau.labs.toolwarehousebackend.dto.ToolWarehouseDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-15T14:59:16+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class ToolWarehouseMapperImpl implements ToolWarehouseMapper {

    @Override
    public ToolWarehouse toEntity(ToolWarehouseDto dto) {
        if ( dto == null ) {
            return null;
        }

        ToolWarehouse toolWarehouse = new ToolWarehouse();

        toolWarehouse.setId( dto.getId() );
        toolWarehouse.setWarehouseName( dto.getWarehouseName() );
        Set<Employee> set = dto.getEmployees();
        if ( set != null ) {
            toolWarehouse.setEmployees( new HashSet<Employee>( set ) );
        }
        Set<Operation> set1 = dto.getOperations();
        if ( set1 != null ) {
            toolWarehouse.setOperations( new HashSet<Operation>( set1 ) );
        }

        return toolWarehouse;
    }

    @Override
    public ToolWarehouseDto toDto(ToolWarehouse entity) {
        if ( entity == null ) {
            return null;
        }

        ToolWarehouseDto toolWarehouseDto = new ToolWarehouseDto();

        toolWarehouseDto.setId( entity.getId() );
        toolWarehouseDto.setWarehouseName( entity.getWarehouseName() );
        Set<Employee> set = entity.getEmployees();
        if ( set != null ) {
            toolWarehouseDto.setEmployees( new HashSet<Employee>( set ) );
        }
        Set<Operation> set1 = entity.getOperations();
        if ( set1 != null ) {
            toolWarehouseDto.setOperations( new HashSet<Operation>( set1 ) );
        }

        return toolWarehouseDto;
    }
}
