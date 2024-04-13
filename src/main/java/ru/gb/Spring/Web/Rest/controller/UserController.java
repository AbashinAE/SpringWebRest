package ru.gb.Spring.Web.Rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.Spring.Web.Rest.services.RegistrationService;
import ru.gb.Spring.Web.Rest.domain.User;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        service.processRegistration(user.getName(), user.getAge(), user.getEmail());
        return "Пользователь успешно создан и зарегистрирован в базе";
    }

    @PostMapping("/param")
    public String userAddFromParam(@RequestParam("name") String name,
                                   @RequestParam("age") int age,
                                   @RequestParam("email") String email) {
        service.processRegistration(name, age, email);
        return "Пользователь успешно создан и зарегистрирован в базе";
    }
}