package com.example.mess.controlls;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.mess.serveces.UserServeces;
import com.example.mess.cook_ras.EncryptionUtil;
import com.example.mess.models.User;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class UserControlls {

     private final UserServeces userServeces;

     UserControlls(UserServeces userServeces) {
          this.userServeces = userServeces;
     }

     @PostMapping("/register/user")
     public User createUser(HttpServletResponse response, @RequestBody User user) {
          if (userServeces.findByName(user.getName()) == null) {
               String sensitiveData = user.getName();
               String encryptedData = EncryptionUtil.encrypt(sensitiveData);
               Cookie secureCookie = new Cookie("APP_SESSION", encryptedData);
               secureCookie.setHttpOnly(true);
               secureCookie.setSecure(true);
               secureCookie.setPath("/");
               secureCookie.setMaxAge(24 * 60 * 60);

               response.addCookie(secureCookie);
               return userServeces.saveUser(user);
          } else {
               return null;
          }
     }

     @GetMapping("/login")
     public User login(HttpServletResponse response, @RequestParam String name, @RequestParam String password) {
          if (userServeces.findByNameAndPassword(name, password) != null) {
               String sensitiveData = name;
               String encryptedData = EncryptionUtil.encrypt(sensitiveData);
               Cookie secureCookie = new Cookie("APP_SESSION", encryptedData);
               secureCookie.setHttpOnly(true);
               secureCookie.setSecure(true);
               secureCookie.setPath("/");
               secureCookie.setMaxAge(24 * 60 * 60);

               response.addCookie(secureCookie);
               return userServeces.findByNameAndPassword(name, password);
          } else {
               return null;
          }
     }

     @DeleteMapping("/delete/user")
     public void deleteUserById(@RequestParam User user) {
          userServeces.deleteUser(user);
     }

     @GetMapping("/get/users")
     public Iterable<User> readSecureCookie(
               @CookieValue(name = "APP_SESSION", defaultValue = "none") String encryptedValue) { // Исправил:
                                                                                                  // Iterable<List> ->
                                                                                                  // Iterable<User>
          if ("none".equals(encryptedValue))
               return null;

          String decrypted = EncryptionUtil.decrypt(encryptedValue);
          if (decrypted.equals("admin")) {
               return userServeces.findAll();
          }
          return null;
     }
}