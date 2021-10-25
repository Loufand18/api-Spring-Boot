package com.example.demo.repository;


import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.data.User;
public interface UserRepository extends CrudRepository<User,Long> {
  public Collection<User> findByLastName(String lastName);
}
