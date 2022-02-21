package ru.ssau.labs.toolwarehousebackend.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ssau.labs.toolwarehousebackend.dao.UserDao;
import ru.ssau.labs.toolwarehousebackend.dto.AuthenticatedUserDto;
import ru.ssau.labs.toolwarehousebackend.dto.UserDto;
import ru.ssau.labs.toolwarehousebackend.mapper.UserMapper;
import ru.ssau.labs.toolwarehousebackend.service.UserDetails;
import ru.ssau.labs.toolwarehousebackend.service.UserDetailsService;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/signin")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;
//    private final JwtUtils jwtUtils;
    private final UserMapper userMapper;

    @PostMapping
    public AuthenticatedUserDto authenticateUser(@RequestBody UserDto userDto) {
        return getAuthenticatedUserDto(userDto);
    }

    private AuthenticatedUserDto getAuthenticatedUserDto(UserDto userDto) {
        AuthenticatedUserDto authenticatedUserDto = new AuthenticatedUserDto();
        UserDetailsService userDetailsService = new UserDetailsService(userDao);
        UserDetails userDetails = userDetailsService.loadUserByUsername(userDto.getUsername(), userDto.getPassword());
        if(userDetails == null) {
            return null;
        }
        authenticatedUserDto.setUsername(userDetails.getUsername());
        authenticatedUserDto.setRole(userDetails.getRole());
        return authenticatedUserDto;
    }


    /*private List<String> getRoles(Authentication authentication) {
        return authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
    }

    @PostMapping("/signup")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void registrationUser(@RequestBody UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User user = userMapper.toEntity(userDto);
        user.setRole(RoleEnum.ROLE_USER);
        userDao.save(user);
    }*/
}
