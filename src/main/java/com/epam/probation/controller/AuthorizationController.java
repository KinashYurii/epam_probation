package com.epam.probation.controller;

import com.epam.probation.DAO.UserRepository;
import com.epam.probation.exception.UserNotFoundException;
import com.epam.probation.model.DTO.UserDTO;
import com.epam.probation.model.entity.Role;
import com.epam.probation.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.security.sasl.AuthenticationException;

@RestController
@RequestMapping("/auth")
public class AuthorizationController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public User register(@ModelAttribute UserDTO userDto) {
//        String encodedPassword = passwordEncoder.encode(userDto.getPassword());

        User user = User.builder()
                .name(userDto.getName())
                .password(userDto.getPassword())
                .role(Role.builder()
                        .id(userDto.getRole().getId())
                        .name(userDto.getName())
                        .build())
                .build();

        return userRepository.save(user);
    }

    @GetMapping("/login")
    public String signIn(@ModelAttribute UserDTO userDto) throws AuthenticationException {
//        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        User registeredUser = userRepository.findById(userDto.getName())
                .orElseThrow(() -> new UserNotFoundException(userDto.getName()));
        if (userDto.getPassword().equals(registeredUser.getPassword())) {
            return "Login is success for user: " + userDto.getName();
        } else {
            throw new AuthenticationException("Wrong pass for user:" + registeredUser.getName());
        }
    }
}
