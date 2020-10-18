package com.example.wbdvf20serverjava.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://slovenly-panda-123456.herokuapp.com"})
//@CrossOrigin()
public class HelloWorldService {
  List<Message> messages = new ArrayList<>();

  @GetMapping("/hello")    // this is a "route"
  public String hello() {
    return "Hello, world.";
  }

  @GetMapping("/hello/{name}")
  public String sayHello(@RequestParam("message") String msg,
      @PathVariable("name") String name) {
    return "Hello, " + name + ": " + msg;
  }

  @GetMapping("/api/messages")
  //@CrossOrigin(origins = "*")
  public List<Message> getMessages() {
    return messages;
  }

  @PostMapping("/api/messages")
  public @ResponseBody Message createMessage(@RequestBody Message newMessage) {
    newMessage.setDate(new Date());
    messages.add(newMessage);
    return newMessage;
  }

  @GetMapping("/api/session/set/{attr}/{value}")
  public String setSessionAttribute(
      @PathVariable("attr") String attr,
      @PathVariable("value") String value,
      HttpSession session) {
    session.setAttribute(attr, value);
    return attr + " = " + value;
  }

  @GetMapping("/api/session/set/{attr}")
  public String getSessionAttribute(
      @PathVariable("attr") String attr,
      HttpSession session) {
    return String.valueOf(session.getAttribute(attr));
  }


}
