package com.example.mess.serveces;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.mess.models.Messang;
import java.util.List;
import com.example.mess.repo.MessageRepo;

@Service
@Transactional(readOnly = true)
public class MessagServeces {

     private final MessageRepo messageRepo;

     public MessagServeces(MessageRepo messageRepo) {
          this.messageRepo = messageRepo;
     }

     public void saveMessage(Messang messang) {
          messageRepo.save(messang);
     }

     public List<Messang> getMessages(String chatname, String from) {
          return messageRepo.findByChatnameAndFrom(chatname, from);
     }

     public void deleteMessage(Long id) {
          messageRepo.deleteById(id);
     }

}
