package com.example.wbdvf20serverjava.services;

import com.example.wbdvf20serverjava.models.Actor;
import com.example.wbdvf20serverjava.models.ActorRepository;
import com.example.wbdvf20serverjava.models.Message;
import com.example.wbdvf20serverjava.models.Movie;
import com.example.wbdvf20serverjava.models.MovieRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://slovenly-panda-123456.herokuapp.com"})
public class MovieController {
  private MovieRepository movieRepository;
  private ActorRepository actorRepository;

  @Autowired
  public MovieController(MovieRepository mr, ActorRepository ar) {
    movieRepository = mr;
    actorRepository = ar;
  }

  @PostMapping("/api/movies")
  public @ResponseBody
  Movie createMessage(@RequestBody Movie newMovie) {
    movieRepository.save(newMovie);
    return newMovie;
  }

  @GetMapping("/api/movies")
  public List<Movie> getMovies() {
    return movieRepository.findAllMovies();
  }

  @GetMapping("/api/actors")
  public List<Actor> getActors() {
    return actorRepository.findAllActors();
  }

  @DeleteMapping("/api/actors/{actorId}")
  public Integer deleteActor(@PathVariable("actorId") Integer actorId) {
    Actor actor = actorRepository.findById(actorId).orElse(null);
    if (actor == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND,
          "Actor with " + actorId + " not found");
    }
    List<Movie> movies = movieRepository.findAllMovies();
    for (Movie m : movies) {
      m.getActors().remove(actor);
    }
    actorRepository.deleteById(actorId);
    return actorId;
  }
}