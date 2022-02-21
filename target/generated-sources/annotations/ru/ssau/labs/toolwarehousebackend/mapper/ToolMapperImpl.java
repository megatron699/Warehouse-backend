package ru.ssau.labs.toolwarehousebackend.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.ssau.labs.toolwarehousebackend.domain.Tool;
import ru.ssau.labs.toolwarehousebackend.dto.ToolDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-15T14:59:16+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class ToolMapperImpl implements ToolMapper {

    @Override
    public Tool toEntity(ToolDto dto) {
        if ( dto == null ) {
            return null;
        }

        Tool tool = new Tool();

        tool.setId( dto.getId() );
        tool.setToolName( dto.getToolName() );
        tool.setManufacturer( dto.getManufacturer() );
        tool.setToolType( dto.getToolType() );

        return tool;
    }

    @Override
    public ToolDto toDto(Tool entity) {
        if ( entity == null ) {
            return null;
        }

        ToolDto toolDto = new ToolDto();

        toolDto.setId( entity.getId() );
        toolDto.setToolName( entity.getToolName() );
        toolDto.setManufacturer( entity.getManufacturer() );
        toolDto.setToolType( entity.getToolType() );

        return toolDto;
    }
}
