package ru.ssau.labs.toolwarehousebackend.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.ssau.labs.toolwarehousebackend.domain.ToolType;
import ru.ssau.labs.toolwarehousebackend.dto.ToolTypeDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-18T13:55:20+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class ToolTypeMapperImpl implements ToolTypeMapper {

    @Override
    public ToolType toEntity(ToolTypeDto dto) {
        if ( dto == null ) {
            return null;
        }

        ToolType toolType = new ToolType();

        toolType.setId( dto.getId() );
        toolType.setToolType( dto.getToolType() );

        return toolType;
    }

    @Override
    public ToolTypeDto toDto(ToolType entity) {
        if ( entity == null ) {
            return null;
        }

        ToolTypeDto toolTypeDto = new ToolTypeDto();

        toolTypeDto.setId( entity.getId() );
        toolTypeDto.setToolType( entity.getToolType() );

        return toolTypeDto;
    }
}
