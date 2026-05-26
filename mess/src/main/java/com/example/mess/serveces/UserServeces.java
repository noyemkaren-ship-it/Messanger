package com.example.mess.serveces;

import org.springframework.stereotype.Service;
import com.example.mess.models.User;
import com.example.mess.repo.UserRepo;
import java.util.List;

@Service
public class UserServeces {
     private final UserRepo userRepo;

     public UserServeces(UserRepo userRepo) {
          this.userRepo = userRepo;
     }

     public User saveUser(User user) {
          return userRepo.save(user);
     }

     public List<User> findAll() {
          return (List<User>) userRepo.findAll();
     }

     public User findByNameAndPassword(String name, String password) {
          return userRepo.findByNameAndPassword(name, password);
     }

     public User findByName(String name) {
          return userRepo.findByName(name);
     }
}
