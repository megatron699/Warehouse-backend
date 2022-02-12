package ru.ssau.labs.toolwarehousebackend.dao;

import org.springframework.data.repository.CrudRepository;
import ru.ssau.labs.toolwarehousebackend.domain.Tool;

public interface ToolDao extends CrudRepository<Tool, Long> {
}
