package com.example.wbdvf20serverjava.models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String title;
  private int year;
  @ManyToMany(cascade = CascadeType.PERSIST)
  private List<Actor> actors;

  public Movie() {

  }

  public List<Actor> getActors() {
    return actors;
  }

  public String getTitle() {
    return title;
  }

  public int getYear() {
    return year;
  }

  public Integer getId() {
    return id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public void setActors(List<Actor> actors) {
    this.actors = actors;
  }
}
