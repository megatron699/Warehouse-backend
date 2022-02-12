package ru.ssau.labs.toolwarehousebackend.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.ssau.labs.toolwarehousebackend.dao.UserDao;
import ru.ssau.labs.toolwarehousebackend.domain.User;
import ru.ssau.labs.toolwarehousebackend.dto.AuthenticatedUserDto;
import ru.ssau.labs.toolwarehousebackend.dto.UserDto;
import ru.ssau.labs.toolwarehousebackend.enums.RoleEnum;
import ru.ssau.labs.toolwarehousebackend.mapper.UserMapper;
import ru.ssau.labs.toolwarehousebackend.security.JwtUtils;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
//@CrossOrigin(origins = "*")
@RestController
//@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    /*@PostMapping("/sighin")
    public void loginUser(@RequestBody UserDto userDto) {
        User user = new User();
        user.setLogin();

        if(user.getLogin() == userDto.getUsername() && user.getPassword() == userDto.getPassword()) {
            return true;
        }
        return false;
    }*/

    private final AuthenticationManager authenticationManager;
    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final UserMapper userMapper;

    @PostMapping("/signin")
    public AuthenticatedUserDto authenticateUser(@RequestBody UserDto userDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        /*String generateJwt = jwtUtils.generateJwt(authentication);
        log.info(generateJwt);*/
        AuthenticatedUserDto authenticatedUserDto = getAuthenticatedUserDto(userDto, authentication);
        return authenticatedUserDto;
    }

    private AuthenticatedUserDto getAuthenticatedUserDto(UserDto userDto, Authentication authentication) {
        AuthenticatedUserDto authenticatedUserDto = new AuthenticatedUserDto();
        authenticatedUserDto.setUsername(userDto.getUsername());
//        authenticatedUserDto.setAccessToken(generateJwt);
        authenticatedUserDto.setRoles(getRoles(authentication));
        return authenticatedUserDto;
    }

    private List<String> getRoles(Authentication authentication) {
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
    }
}
