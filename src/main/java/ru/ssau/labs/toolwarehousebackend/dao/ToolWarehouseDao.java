package ru.ssau.labs.toolwarehousebackend.dao;

import org.springframework.data.repository.CrudRepository;
import ru.ssau.labs.toolwarehousebackend.domain.ToolWarehouse;

public interface ToolWarehouseDao extends CrudRepository<ToolWarehouse, Long> {
}
