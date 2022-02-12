package ru.ssau.labs.toolwarehousebackend.dao;

import org.springframework.data.repository.CrudRepository;
import ru.ssau.labs.toolwarehousebackend.domain.Operation;

public interface OperationDao extends CrudRepository<Operation, Long> {
}
