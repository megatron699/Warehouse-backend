package ru.ssau.labs.toolwarehousebackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.ssau.labs.toolwarehousebackend.dto.OperationTypeDto;
import ru.ssau.labs.toolwarehousebackend.service.OperationTypeService;

import javax.validation.Valid;
import java.util.List;

@Validated
//@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/operation-types")
@RequiredArgsConstructor
public class OperationTypeController {
    private final OperationTypeService operationTypeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OperationTypeDto save(@RequestBody @Valid OperationTypeDto operationTypeDto) {
        return operationTypeService.save(operationTypeDto);
    }

    @PutMapping("/{id}")
    public OperationTypeDto update(@RequestBody @Valid OperationTypeDto operationTypeDto, @PathVariable Long id) {
        operationTypeDto.setId(id);
        return operationTypeService.update(operationTypeDto);
    }

    @GetMapping(value = "/{id}")
    public OperationTypeDto get(@PathVariable Long id) {
        return operationTypeService.getOperationType(id);
    }

    @GetMapping
    public List<OperationTypeDto> getAll() {
        return operationTypeService.getAll();
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void delete(@PathVariable Long id) {
        operationTypeService.delete(id);
    }
}
