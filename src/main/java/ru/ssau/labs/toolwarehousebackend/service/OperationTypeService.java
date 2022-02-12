package ru.ssau.labs.toolwarehousebackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ssau.labs.toolwarehousebackend.dao.OperationTypeDao;
import ru.ssau.labs.toolwarehousebackend.dao.ToolDao;
import ru.ssau.labs.toolwarehousebackend.domain.OperationType;
import ru.ssau.labs.toolwarehousebackend.dto.OperationTypeDto;
import ru.ssau.labs.toolwarehousebackend.exception.EntityNotExistException;
import ru.ssau.labs.toolwarehousebackend.mapper.OperationTypeMapper;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class OperationTypeService {
    private final OperationTypeDao operationTypeDao;

    private final OperationTypeMapper operationTypeMapper;

    public OperationTypeDto save(OperationTypeDto operationTypeDto) {
        OperationType operationType = operationTypeMapper.toEntity(operationTypeDto);
        operationType = operationTypeDao.save(operationType);
        return operationTypeMapper.toDto(operationType);
    }

    public OperationTypeDto update(OperationTypeDto operationTypeDto) {
        if (operationTypeDao.existsById(operationTypeDto.getId())) {
            OperationType operationType = operationTypeDao.save(operationTypeMapper.toEntity(operationTypeDto));
            return operationTypeMapper.toDto(operationType);
        } else {
            throw new EntityNotExistException("Такого типа операции не существует");
        }
    }

    public OperationTypeDto getOperationType(Long id) {
        OperationType operationType = operationTypeDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Тип операции не найден"));
        return operationTypeMapper.toDto(operationType);
    }

    public void delete(Long id) {
        operationTypeDao.deleteById(id);
    }

    public List<OperationTypeDto> getAll() {
        Iterable<OperationType> operationType = operationTypeDao.findAll();
        return StreamSupport.stream(operationType.spliterator(), false)
                .map(operationTypeMapper::toDto)
                .collect(Collectors.toList());
    }
}
