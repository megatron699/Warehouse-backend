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
import ru.ssau.labs.toolwarehousebackend.dto.ToolWarehouseDto;
import ru.ssau.labs.toolwarehousebackend.service.ToolWarehouseService;

import javax.validation.Valid;
import java.util.List;

@Validated
//@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/tool-warehouses")
@RequiredArgsConstructor
public class ToolWarehouseController {
    private final ToolWarehouseService toolWarehouseService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public ToolWarehouseDto save(@RequestBody @Valid ToolWarehouseDto toolWarehouseDto) {
        return toolWarehouseService.save(toolWarehouseDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ToolWarehouseDto update(@RequestBody @Valid ToolWarehouseDto toolWarehouseDto, @PathVariable Long id) {
        toolWarehouseDto.setId(id);
        return toolWarehouseService.update(toolWarehouseDto);
    }

    @GetMapping(value = "/{id}")
    public ToolWarehouseDto get(@PathVariable Long id) {
        return toolWarehouseService.getToolWarehouse(id);
    }

    @GetMapping
    public List<ToolWarehouseDto> getAll() {
        return toolWarehouseService.getAll();
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void delete(@PathVariable Long id) {
        toolWarehouseService.delete(id);
    }
}
