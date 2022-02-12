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
import ru.ssau.labs.toolwarehousebackend.dto.EmployeeDto;
import ru.ssau.labs.toolwarehousebackend.service.EmployeeService;

import javax.validation.Valid;
import java.util.List;

@Validated
//@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDto save(@RequestBody @Valid EmployeeDto employeeDto) {
        return employeeService.save(employeeDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public EmployeeDto update(@RequestBody @Valid EmployeeDto employeeDto, @PathVariable Long id) {
        employeeDto.setId(id);
        return employeeService.update(employeeDto);
    }

    @GetMapping(value = "/{id}")
    public EmployeeDto get(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }

    @GetMapping
    public List<EmployeeDto> getAll() {
        return employeeService.getAll();
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void delete(@PathVariable Long id) {
        employeeService.delete(id);
    }
}
