package com.example.wbdvf20serverjava.models;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Integer> {

  @Query("select message from Message message")    // JPQL
  List<Message> findAllMessages();

  @Query("select message from Message message where message.id=:id")
  Message findMessageById(Integer id);

}
