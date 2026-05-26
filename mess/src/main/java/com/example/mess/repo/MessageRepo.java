package com.example.mess.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.mess.models.Messang;
import java.util.List;

@Repository
public interface MessageRepo extends CrudRepository<Messang, Long> {
     Messang findByChatname(String chatname);

     List<Messang> findByChatAndFrom(String chatname, String from);
}
