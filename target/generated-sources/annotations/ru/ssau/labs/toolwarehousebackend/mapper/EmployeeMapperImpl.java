package ru.ssau.labs.toolwarehousebackend.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.ssau.labs.toolwarehousebackend.domain.Employee;
import ru.ssau.labs.toolwarehousebackend.dto.EmployeeDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-15T14:59:16+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public Employee toEntity(EmployeeDto dto) {
        if ( dto == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId( dto.getId() );
        employee.setLastName( dto.getLastName() );
        employee.setFirstName( dto.getFirstName() );
        employee.setPatronymic( dto.getPatronymic() );
        employee.setPosition( dto.getPosition() );
        employee.setToolWarehouse( dto.getToolWarehouse() );

        return employee;
    }

    @Override
    public EmployeeDto toDto(Employee entity) {
        if ( entity == null ) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setId( entity.getId() );
        employeeDto.setLastName( entity.getLastName() );
        employeeDto.setFirstName( entity.getFirstName() );
        employeeDto.setPatronymic( entity.getPatronymic() );
        employeeDto.setPosition( entity.getPosition() );
        employeeDto.setToolWarehouse( entity.getToolWarehouse() );

        return employeeDto;
    }
}
