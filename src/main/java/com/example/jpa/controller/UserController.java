package com.example.jpa.controller;

import com.example.jpa.dto.User;
import com.example.jpa.dto.UserDto;
import com.example.jpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //GET
    @GetMapping
    public ResponseEntity<?> getUser(){
        List<User> users = userService.getUser();
        return ResponseEntity.ok(users);
    }

    //GET-ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserId(@PathVariable Long id){
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    //POST
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto){
        User user = userService.createUser(userDto);
        return ResponseEntity.ok(user);
    }

    //PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserDto userDto){
        User updateUser = userService.updateUser(id, userDto);
        return ResponseEntity.ok(updateUser);
    }

    //PATCH
    @PatchMapping("/{id}")
    public ResponseEntity<?> patchUser(@PathVariable Long id, @RequestBody UserDto userDto){
        User patchedUser = userService.patchUser(id, userDto);
        return ResponseEntity.ok(patchedUser);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
