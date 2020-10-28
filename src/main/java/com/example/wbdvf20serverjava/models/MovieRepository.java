package com.example.wbdvf20serverjava.models;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Integer> {
  @Query("select movie from Movie movie")
  List<Movie> findAllMovies();
}