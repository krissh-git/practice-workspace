package com.krishna.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public void create(@RequestBody User user) {
        userRepository.save(user);
    }

    @GetMapping("/{id}")
    public User read(@PathVariable("id") String id) {
        return userRepository.findOne(id);
    }

    @GetMapping("/all")
    public List<User> readAll() {
        return userRepository.findAll();
    }

//    @GetMapping("/{name}")
//    public User readByName(@PathVariable("name") String name) {
//        return userRepository.findOneByUser(name);
//    }

    @PutMapping
    public User update(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        userRepository.delete(id);
    }


}
