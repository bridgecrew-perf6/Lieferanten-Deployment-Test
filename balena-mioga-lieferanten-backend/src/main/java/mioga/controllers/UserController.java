package mioga.controllers;


import mioga.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {



    @Autowired
    final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }





}
