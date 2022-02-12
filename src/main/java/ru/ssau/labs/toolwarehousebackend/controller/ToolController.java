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
import ru.ssau.labs.toolwarehousebackend.dto.ToolDto;
import ru.ssau.labs.toolwarehousebackend.service.ToolService;

import javax.validation.Valid;
import java.util.List;

@Validated
//@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/tools")
@RequiredArgsConstructor
public class ToolController {
    private final ToolService toolService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public ToolDto save(@RequestBody @Valid ToolDto toolDto) {
        return toolService.save(toolDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ToolDto update(@RequestBody @Valid ToolDto toolDto, @PathVariable Long id) {
        toolDto.setId(id);
        return toolService.update(toolDto);
    }

    @GetMapping(value = "/{id}")
    public ToolDto get(@PathVariable Long id) {
        return toolService.getTool(id);
    }

    @GetMapping
    public List<ToolDto> getAll() {
        return toolService.getAll();
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void delete(@PathVariable Long id) {
        toolService.delete(id);
    }
}
