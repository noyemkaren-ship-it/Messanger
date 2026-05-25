package com.example.mess.repo;

import com.example.mess.models.Chat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ChatRepo extends CrudRepository<Chat, Long> {
     List<Chat> findByFirstUser(String firstUser);

     Chat findByFirstUserAndSecondUser(String firstUser, String secondUser);

}
