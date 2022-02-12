package ru.ssau.labs.toolwarehousebackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ssau.labs.toolwarehousebackend.dao.ToolWarehouseDao;
import ru.ssau.labs.toolwarehousebackend.domain.ToolWarehouse;
import ru.ssau.labs.toolwarehousebackend.dto.ToolWarehouseDto;
import ru.ssau.labs.toolwarehousebackend.exception.EntityNotExistException;
import ru.ssau.labs.toolwarehousebackend.mapper.ToolWarehouseMapper;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ToolWarehouseService {
    private final ToolWarehouseDao toolWarehouseDao;

    private final ToolWarehouseMapper toolWarehouseMapper;

    public ToolWarehouseDto save(ToolWarehouseDto toolWarehouseDto) {
        ToolWarehouse toolWarehouse = toolWarehouseMapper.toEntity(toolWarehouseDto);
        toolWarehouse = toolWarehouseDao.save(toolWarehouse);
        return toolWarehouseMapper.toDto(toolWarehouse);
    }

    public ToolWarehouseDto update(ToolWarehouseDto toolWarehouseDto) {
        if (toolWarehouseDao.existsById(toolWarehouseDto.getId())) {
            ToolWarehouse toolWarehouse = toolWarehouseDao.save(toolWarehouseMapper.toEntity(toolWarehouseDto));
            return toolWarehouseMapper.toDto(toolWarehouse);
        } else {
            throw new EntityNotExistException("Такого склада не существует");
        }
    }

    public ToolWarehouseDto getToolWarehouse(Long id) {
        ToolWarehouse toolWarehouse = toolWarehouseDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Склад не найден"));
        return toolWarehouseMapper.toDto(toolWarehouse);
    }

    public void delete(Long id) {
        toolWarehouseDao.deleteById(id);
    }

    public List<ToolWarehouseDto> getAll() {
        Iterable<ToolWarehouse> toolWarehouse = toolWarehouseDao.findAll();
        return StreamSupport.stream(toolWarehouse.spliterator(), false)
                .map(toolWarehouseMapper::toDto)
                .collect(Collectors.toList());
    }
}
