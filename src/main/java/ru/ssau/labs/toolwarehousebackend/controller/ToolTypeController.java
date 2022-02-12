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
import ru.ssau.labs.toolwarehousebackend.dto.ToolTypeDto;
import ru.ssau.labs.toolwarehousebackend.service.ToolTypeService;

import javax.validation.Valid;
import java.util.List;

@Validated
//@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/tool-types")
@RequiredArgsConstructor
public class ToolTypeController {
    private final ToolTypeService toolTypeService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public ToolTypeDto save(@RequestBody @Valid ToolTypeDto toolTypeDto) {
        return toolTypeService.save(toolTypeDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ToolTypeDto update(@RequestBody @Valid ToolTypeDto toolTypeDto, @PathVariable Long id) {
        toolTypeDto.setId(id);
        return toolTypeService.update(toolTypeDto);
    }

    @GetMapping(value = "/{id}")
    public ToolTypeDto get(@PathVariable Long id) {
        return toolTypeService.getToolType(id);
    }

    @GetMapping
    public List<ToolTypeDto> getAll() {
        return toolTypeService.getAll();
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void delete(@PathVariable Long id) {
        toolTypeService.delete(id);
    }
}
