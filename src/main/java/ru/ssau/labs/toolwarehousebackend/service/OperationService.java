package ru.ssau.labs.toolwarehousebackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ssau.labs.toolwarehousebackend.dao.OperationDao;
import ru.ssau.labs.toolwarehousebackend.domain.Operation;
import ru.ssau.labs.toolwarehousebackend.dto.OperationDto;
import ru.ssau.labs.toolwarehousebackend.exception.EntityNotExistException;
import ru.ssau.labs.toolwarehousebackend.mapper.OperationMapper;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class OperationService {
    private final OperationDao operationDao;

    private final OperationMapper operationMapper;

    public OperationDto save(OperationDto operationDto) {
        Operation operation = operationMapper.toEntity(operationDto);
        operation = operationDao.save(operation);
        return operationMapper.toDto(operation);
    }

    public OperationDto update(OperationDto operationDto) {
        if (operationDao.existsById(operationDto.getId())) {
            Operation operation = operationDao.save(operationMapper.toEntity(operationDto));
            return operationMapper.toDto(operation);
        } else {
            throw new EntityNotExistException("Такой операции не существует");
        }
    }

    public OperationDto getOperation(Long id) {
        Operation operation = operationDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Операция не найдена"));
        return operationMapper.toDto(operation);
    }

    public void delete(Long id) {
        operationDao.deleteById(id);
    }

    public List<OperationDto> getAll() {
        Iterable<Operation> operation = operationDao.findAll();
        return StreamSupport.stream(operation.spliterator(), false)
                .map(operationMapper::toDto)
                .collect(Collectors.toList());
    }
}
