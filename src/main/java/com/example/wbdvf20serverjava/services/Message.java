package com.example.wbdvf20serverjava.services;

import java.util.Date;

/**
 * Data object representing a message in a chat application.
 */
// POJO "plain old java object"
public class Message {
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
