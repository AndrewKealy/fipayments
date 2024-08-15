package com.neueda.payments.control;

import com.neueda.payments.exceptions.UserNotFoundException;
import com.neueda.payments.model.User;
import com.neueda.payments.model.UserDTO;
import com.neueda.payments.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> retrieveAllUsers() {
            return userService.getAllUsers().stream().map(UserDTO::new).toList();
        }

    @GetMapping(value = "/{id}", produces =  {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public UserDTO getUserById(@PathVariable("id") Long id) throws UserNotFoundException {
        return new UserDTO(userService.getUserById(id));
    }

    @PostMapping
    public User createNewUser(@RequestBody User newUser) {
        return userService.save(newUser);
    }
}
