package ru.savin.minicrm.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.savin.minicrm.dto.FormUser;
import ru.savin.minicrm.entity.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);

    User findByEmail(String email);

    User save(FormUser formUser);

    List<User> findAll();

    void delete(Long id);

}
