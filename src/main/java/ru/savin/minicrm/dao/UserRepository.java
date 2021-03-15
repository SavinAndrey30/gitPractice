package ru.savin.minicrm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import ru.savin.minicrm.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

    User findByEmail(String email);

    List<User> findAll();

}
