package ru.ssau.labs.toolwarehousebackend.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.ssau.labs.toolwarehousebackend.domain.User;
import ru.ssau.labs.toolwarehousebackend.dto.UserDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-18T13:55:20+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setLogin( dto.getUsername() );
        user.setPassword( dto.getPassword() );

        return user;
    }

    @Override
    public UserDto toDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setUsername( entity.getLogin() );
        userDto.setPassword( entity.getPassword() );

        return userDto;
    }
}
