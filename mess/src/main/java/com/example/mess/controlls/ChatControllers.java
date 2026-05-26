package com.example.mess.controlls;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.mess.serveces.ChatService;
import com.example.mess.models.Chat;

@RestController
public class ChatControllers {
    private final ChatService chatService;

    public ChatControllers(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/chat/{firstUser}/{secondUser}")
    public Chat getChat(@PathVariable("firstUser") String firstUser,
            @PathVariable("secondUser") String secondUser) {

        return chatService.getChatByFirstAndSecondUser(firstUser, secondUser);
    }

    @PostMapping("/chat")
    public Chat saveChat(@RequestBody Chat chat) {
        return chatService.saveChat(chat);
    }

    @GetMapping("/chats/{user_name}")
    public Iterable<Chat> getChats(@PathVariable("user_name") String user_name) {
        return chatService.getChatsByFirstUser(user_name);
    }
}
