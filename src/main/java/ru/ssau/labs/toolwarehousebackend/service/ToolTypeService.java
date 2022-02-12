package ru.ssau.labs.toolwarehousebackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ssau.labs.toolwarehousebackend.dao.ToolTypeDao;
import ru.ssau.labs.toolwarehousebackend.domain.ToolType;
import ru.ssau.labs.toolwarehousebackend.dto.ToolTypeDto;
import ru.ssau.labs.toolwarehousebackend.exception.EntityNotExistException;
import ru.ssau.labs.toolwarehousebackend.mapper.ToolTypeMapper;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ToolTypeService {
    private final ToolTypeDao toolTypeDao;

    private final ToolTypeMapper toolTypeMapper;

    public ToolTypeDto save(ToolTypeDto toolTypeDto) {
        ToolType toolType = toolTypeMapper.toEntity(toolTypeDto);
        toolType = toolTypeDao.save(toolType);
        return toolTypeMapper.toDto(toolType);
    }

    public ToolTypeDto update(ToolTypeDto toolTypeDto) {
        if (toolTypeDao.existsById(toolTypeDto.getId())) {
            ToolType toolType = toolTypeDao.save(toolTypeMapper.toEntity(toolTypeDto));
            return toolTypeMapper.toDto(toolType);
        } else {
            throw new EntityNotExistException("Такого типа инструментов не существует");
        }
    }

    public ToolTypeDto getToolType(Long id) {
        ToolType toolType = toolTypeDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Тип инструментов не найден"));
        return toolTypeMapper.toDto(toolType);
    }

    public void delete(Long id) {
        toolTypeDao.deleteById(id);
    }

    public List<ToolTypeDto> getAll() {
        Iterable<ToolType> toolType = toolTypeDao.findAll();
        return StreamSupport.stream(toolType.spliterator(), false)
                .map(toolTypeMapper::toDto)
                .collect(Collectors.toList());
    }
}
