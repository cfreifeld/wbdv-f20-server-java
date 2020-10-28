package com.example.wbdvf20serverjava.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "actors")
public class Actor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;

  @ManyToMany(mappedBy = "actors", cascade = CascadeType.PERSIST)
  private List<Movie> movies;

  public Actor() {

  }

  public String getName() {
    return name;
  }

  @JsonIgnore
  public List<Movie> getMovies() {
    return movies;
  }

  public Integer getId() {
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setMovies(List<Movie> movies) {
    this.movies = movies;
  }
}
