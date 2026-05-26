package com.example.mess.controlls;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.mess.serveces.UserServeces;
import com.example.mess.models.User;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class UserControlls {

     private final UserServeces userServeces;

     UserControlls(UserServeces userServeces) {
          this.userServeces = userServeces;
     }

     @PostMapping("/create/user")
     public User createUser(@RequestBody User user) {
          if (userServeces.findByName(user.getName()) == null) {
               return userServeces.saveUser(user);
          } else {
               return null;
          }
     }

     @GetMapping("/login")
     public User login(@RequestParam String name, @RequestParam String password) {
          return userServeces.findByNameAndPassword(name, password);
     }

     @DeleteMapping("/delete/user")
     public void deleteUserById(@RequestParam User user) {
          userServeces.deleteUser(user);
     }

     @GetMapping("/get/users")
     public Iterable<User> getUsers() {
          return userServeces.findAll();
     }

}
