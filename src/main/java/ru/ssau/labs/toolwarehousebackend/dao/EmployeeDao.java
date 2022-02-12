package ru.ssau.labs.toolwarehousebackend.dao;

import org.springframework.data.repository.CrudRepository;
import ru.ssau.labs.toolwarehousebackend.domain.Employee;

public interface EmployeeDao extends CrudRepository<Employee, Long> {
}
