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
import ru.ssau.labs.toolwarehousebackend.dto.OperationDto;
import ru.ssau.labs.toolwarehousebackend.service.OperationService;

import javax.validation.Valid;
import java.util.List;

@Validated
//@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/operations")
@RequiredArgsConstructor
public class OperationController {
    private final OperationService operationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OperationDto save(@RequestBody @Valid OperationDto operationDto) {
        return operationService.save(operationDto);
    }

    @PutMapping("/{id}")
    public OperationDto update(@RequestBody @Valid OperationDto operationDto, @PathVariable Long id) {
        operationDto.setId(id);
        return operationService.update(operationDto);
    }

    @GetMapping(value = "/{id}")
    public OperationDto get(@PathVariable Long id) {
        return operationService.getOperation(id);
    }

    @GetMapping
    public List<OperationDto> getAll() {
        return operationService.getAll();
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void delete(@PathVariable Long id) {
        operationService.delete(id);
    }
}
