package com.example.wbdvf20serverjava.models;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ActorRepository extends CrudRepository<Actor, Integer> {
  @Query("select actor from Actor actor")
  List<Actor> findAllActors();
}
