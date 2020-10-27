package com.example.wbdvf20serverjava.services;

import com.example.wbdvf20serverjava.models.Message;
import com.example.wbdvf20serverjava.models.MessageRepository;
import com.example.wbdvf20serverjava.models.User;
import com.example.wbdvf20serverjava.models.UserRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
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
public class HelloWorldService {
  List<Message> messages = new ArrayList<>();

  private MessageRepository messageRepository;
  private UserRepository userRepository;

  @Autowired  // "inversion of control"
  public HelloWorldService(MessageRepository rep, UserRepository ur) {
    this.messageRepository = rep;
    this.userRepository = ur;
  }

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
  public List<Message> getMessages() {
    //return messages;
    //return (List<Message>) repository.findAll();
    return messageRepository.findAllMessages();
  }

  @GetMapping("/api/messages/{messageId}")
  public Message getMessages(@PathVariable("messageId") Integer messageId) {
    //return messages;
    //Optional<Message> msg = repository.findById(messageId);
    //return msg.orElse(null);
    return messageRepository.findMessageById(messageId);
  }

  @PostMapping("/api/messages")
  public @ResponseBody Message createMessage(@RequestBody Message newMessage) {
    newMessage.setDate(new Date());
    //messages.add(newMessage);
    User u = userRepository.findUserById(newMessage.getUser().getId());
    if (u != null) {
      newMessage.setUser(u);
    }
    messageRepository.save(newMessage);
    return newMessage;
  }

  @GetMapping("/api/users")
  public List<User> getUsers() {
    return userRepository.findAllUsers();
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
