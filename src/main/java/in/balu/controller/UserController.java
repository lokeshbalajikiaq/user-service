package in.balu.controller;

import in.balu.dto.UserDto;
import in.balu.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class UserController {

    Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserDto createUser(@Valid @RequestBody UserDto userDto) {
        log.info("User Controller :: createUser {}", userDto.getEmailAddress());
        return userService.save(userDto);
    }

    @GetMapping("/{userId}")
    @ResponseStatus(code = HttpStatus.OK)
    public UserDto fetchUser(@PathVariable Integer userId) {
        log.info("UserController :: fetchUser for {}", userId);
        return userService.findById(userId);
    }
}