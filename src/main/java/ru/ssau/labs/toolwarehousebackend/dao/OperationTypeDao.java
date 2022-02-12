package ru.ssau.labs.toolwarehousebackend.dao;

import org.springframework.data.repository.CrudRepository;
import ru.ssau.labs.toolwarehousebackend.domain.OperationType;

public interface OperationTypeDao extends CrudRepository<OperationType, Long> {
}
