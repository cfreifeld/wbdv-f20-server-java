package com.example.wbdvf20serverjava.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
  private String text;
  private Date date;

  public Message() {
    text = null;
    date = null;
  }

  public Message(String text, Date date) {
    this.text = text;
    this.date = date;
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
}
