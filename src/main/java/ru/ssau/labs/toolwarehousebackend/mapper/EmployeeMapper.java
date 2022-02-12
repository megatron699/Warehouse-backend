package ru.ssau.labs.toolwarehousebackend.mapper;

import org.mapstruct.Mapper;
import ru.ssau.labs.toolwarehousebackend.domain.Employee;
import ru.ssau.labs.toolwarehousebackend.dto.EmployeeDto;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee toEntity(EmployeeDto dto);

    EmployeeDto toDto(Employee entity);
}
