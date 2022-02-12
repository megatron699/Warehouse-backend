package ru.ssau.labs.toolwarehousebackend.dao;

import org.springframework.data.repository.CrudRepository;
import ru.ssau.labs.toolwarehousebackend.domain.ToolType;

public interface ToolTypeDao extends CrudRepository<ToolType, Long> {
}
