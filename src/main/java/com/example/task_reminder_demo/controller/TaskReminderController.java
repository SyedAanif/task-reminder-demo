package com.example.task_reminder_demo.controller;

import com.example.task_reminder_demo.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// API
// REST --> verbs -> GET, POST, DELETE, PUT, PATCH, TRACE, HEAD, OPTIONS
@RestController
public class TaskReminderController {

//    User[] userArray = {
//     new User(1,"foo", "xyz"),
//     new User(2,"bar", "abc"),
//    };

    List<User> usersList = new ArrayList<>();

//    public TaskReminderController() {
//        usersList.add(new User(1,"foo", "xyz"));
//        usersList.add(new User(2,"bar", "abc"));
//    }

    @GetMapping
    public List<User> getAllUsers() {
        return usersList;
    }

    @GetMapping(path = "/{id}")
    public User getAUser(@PathVariable(name = "id") int id) {
        // predicate
        Optional<User> first = usersList.stream().filter(user -> user.getId() == id).findFirst();

        return first.get();
    }

    @GetMapping(path = "/users")
    public List<User> getAllUsersOrNone(@RequestParam String name) {
        if (name == null) {
            return usersList;
        }
        return usersList.stream().filter(user -> user.getName().equals(name)).findFirst().stream().toList();
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        usersList.add(user);
        // HATEOAS
    }
}

// localhost:9001/hello
// URI
// scheme(protocol)://authority/path?query=
// http(s)://example.com/hello/{name}?name=xyz
// REST -> RMM 3 points
// GET /users
// GET /users/user/{id}
// http(s)://IP:POrt
// fqdn
// wss://
// psql://usernam@pass
// mqtt://
//
// Domain --> DNS
//example.com/   IP Address -> ipv4, ipv6
// 127.0.0.1 --> /etc/hosts
// 80, 443, 8443, 5142, 22

// versioning
// v1
