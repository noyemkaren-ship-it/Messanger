package com.example.mess.models;

import jakarta.persistence.*;

@Entity
@Table(name = "chats")
public class Chat {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     @Column(nullable = false)
     private String name;

     @Column(name = "first_user", nullable = false)
     private String firstUser;

     @Column(name = "second_user", nullable = false)
     private String secondUser;

     public Chat() {
     }

     public Chat(String name, String firstUser, String secondUser) {
          this.name = name;
          this.firstUser = firstUser;
          this.secondUser = secondUser;
     }

     public Long getId() {
          return id;
     }

     public void setId(Long id) {
          this.id = id;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getFirstUser() {
          return firstUser;
     }

     public void setFirstUser(String firstUser) {
          this.firstUser = firstUser;
     }

     public String getSecondUser() {
          return secondUser;
     }

     public void setSecondUser(String secondUser) {
          this.secondUser = secondUser;
     }

}
