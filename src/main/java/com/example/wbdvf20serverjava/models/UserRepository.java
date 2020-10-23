package com.example.wbdvf20serverjava.models;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

  @Query("select user from User user where user.id=:id")
  User findUserById(Integer id);

  @Query("select user from User user where user.name=:name")
  User findUserByName(String name);

  @Query("select user from User user")
  List<User> findAllUsers();

  @Query("select count(user.name) from User user where user.name=:name")
  Long checkCredentials(String name);
  //Message save()

}
