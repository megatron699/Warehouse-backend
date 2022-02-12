package ru.ssau.labs.toolwarehousebackend.mapper;

import org.mapstruct.Mapper;
import ru.ssau.labs.toolwarehousebackend.domain.Operation;
import ru.ssau.labs.toolwarehousebackend.dto.OperationDto;

@Mapper(componentModel = "spring")
public interface OperationMapper {

    Operation toEntity(OperationDto dto);

    OperationDto toDto(Operation entity);

    /*default OperationDto operationToOperationDto(Operation operation) {
        if(operation == null) {
            return null;
        }
        OperationDto operationDto = new OperationDto();
        operation.set
    }*/
    /*default RestorationDto restorationToRestorationDto(Restoration restoration) {
        if ( restoration == null ) {
            return null;
        }

        RestorationDto restorationDto = new RestorationDto();

        restorationDto.setId( restoration.getId() );
        restorationDto.setStartDate( restoration.getStartDate() );
        restorationDto.setEndDate( restoration.getEndDate() );
        restorationDto.setComment( restoration.getComment() );

        return restorationDto;
    }

    default Set<RestorationDto> restorationSetToRestorationDtoSet(Set<Restoration> set) {
        if ( set == null ) {
            return null;
        }

        Set<RestorationDto> set1 = new HashSet<RestorationDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Restoration restoration : set ) {
            set1.add( restorationToRestorationDto( restoration ) );
        }

        return set1;
    }

    default EmployeeDto employeeToEmployeeDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setId( employee.getId() );
        employeeDto.setEmployeeNumber( employee.getEmployeeNumber() );
        employeeDto.setFullName( employee.getFullName() );
        employeeDto.setPosition( employee.getPosition() );

        return employeeDto;
    }*/
}
