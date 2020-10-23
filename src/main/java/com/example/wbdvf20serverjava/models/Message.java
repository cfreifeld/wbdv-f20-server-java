package com.example.wbdvf20serverjava.models;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Data object representing a message in a chat application.
 */
@Entity
@Table(name="messages")
public class Message {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(length=1000)
  private String text;
  private Date date;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name="user_id")
  private User user;

  public Message() {
    text = null;
    date = null;
  }

  public Message(String text, Date date, User user) {
    this.text = text;
    this.date = date;
    this.user = user;
  }

  public String getText() {
    return text;
  }

  public Date getDate() {
    return date;
  }

  public void setText(String text) {
    this.text = text;
  }

  public void setDate(Date d) {
    this.date = new Date();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setUser(User u) {
    this.user = u;
  }

//  public User getUser() {
//    return user;
//  }
//
//  public Integer getUsersId() {
//    return usersId;
//  }
}
