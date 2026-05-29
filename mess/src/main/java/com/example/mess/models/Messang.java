package com.example.mess.models;

import jakarta.persistence.*;

@Entity
@Table(name = "messangs")
public class Messang {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     @Column(nullable = false)
     private String text;

     @Column(name = "sender", nullable = false)
     private String from;

     @Column(nullable = false)
     private String chatname;

     public Messang() {
     }

     public Messang(String text, String from, String chatname) {
          this.text = text;
          this.from = from;
          this.chatname = chatname;
     }

     public Long getId() {
          return id;
     }

     public void setId(Long id) {
          this.id = id;
     }

     public String getText() {
          return text;
     }

     public void setText(String text) {
          this.text = text;
     }

     public String getFrom() {
          return from;
     }

     public void setFrom(String from) {
          this.from = from;
     }

     public String getChatname() {
          return chatname;
     }

     public void setChatname(String chatname) {
          this.chatname = chatname;
     }
}
