package com.myportfolio.jwtlogin.dao;

import com.myportfolio.jwtlogin.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, String> {
}
