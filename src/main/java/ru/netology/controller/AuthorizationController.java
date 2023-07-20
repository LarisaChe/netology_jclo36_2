package ru.netology.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.repository.Authorities;
import ru.netology.service.AuthorizationService;
import ru.netology.user.User;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    //    @GetMapping("/authorize")
//    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
//        return service.getAuthorities(user, password);
//    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Validated User user) {
        return service.getAuthorities(user.getUser(), user.getPassword());
    }
}
