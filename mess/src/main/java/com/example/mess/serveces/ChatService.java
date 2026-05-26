package com.example.mess.serveces;

import org.springframework.stereotype.Service;
import com.example.mess.repo.ChatRepo;
import com.example.mess.models.Chat;

@Service
public class ChatService {

    private final ChatRepo chatRepo;

    public ChatService(ChatRepo chatRepo) {
        this.chatRepo = chatRepo;
    }

    public Chat getChatByFirstAndSecondUser(String firstUser, String secondUser) {
        return chatRepo.findByFirstUserAndSecondUser(firstUser, secondUser);
    }

    public Chat saveChat(Chat chat) {
        return chatRepo.save(chat);
    }

    public Iterable<Chat> getAllChats() {
        return chatRepo.findAll();
    }

    public Iterable<Chat> getChatsByFirstUser(String firstUser) {
        return chatRepo.findByFirstUser(firstUser);
    }
}
