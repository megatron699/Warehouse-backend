package ru.ssau.labs.toolwarehousebackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ssau.labs.toolwarehousebackend.dao.OperationTypeDao;
import ru.ssau.labs.toolwarehousebackend.dao.ToolDao;
import ru.ssau.labs.toolwarehousebackend.domain.Tool;
import ru.ssau.labs.toolwarehousebackend.dto.ToolDto;
import ru.ssau.labs.toolwarehousebackend.exception.EntityNotExistException;
import ru.ssau.labs.toolwarehousebackend.mapper.ToolMapper;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ToolService {
    private final ToolDao toolDao;

    private final ToolMapper toolMapper;

    public ToolDto save(ToolDto toolDto) {
        Tool tool = toolMapper.toEntity(toolDto);
        tool = toolDao.save(tool);
        return toolMapper.toDto(tool);
    }

    public ToolDto update(ToolDto toolDto) {
        if (toolDao.existsById(toolDto.getId())) {
            Tool tool = toolDao.save(toolMapper.toEntity(toolDto));
            return toolMapper.toDto(tool);
        } else {
            throw new EntityNotExistException("Такого инструмента не существует");
        }
    }

    public ToolDto getTool(Long id) {
        Tool tool = toolDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Инструмент не найден"));
        return toolMapper.toDto(tool);
    }

    public void delete(Long id) {
        toolDao.deleteById(id);
    }

    public List<ToolDto> getAll() {
        Iterable<Tool> tool = toolDao.findAll();
        return StreamSupport.stream(tool.spliterator(), false)
                .map(toolMapper::toDto)
                .collect(Collectors.toList());
    }
}
