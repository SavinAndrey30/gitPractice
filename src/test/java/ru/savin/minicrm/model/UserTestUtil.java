package ru.savin.minicrm.model;


import ru.savin.minicrm.dto.FormUser;
import ru.savin.minicrm.entity.Role;
import ru.savin.minicrm.entity.User;

import java.util.List;

/**
 * An utility class which contains useful methods for unit testing user related
 * functions.
 */
public class UserTestUtil {

    public static FormUser createDTO(String username, String password, String firstName, String lastName,
                                     String email) {
        FormUser dto = new FormUser();

        dto.setUserName(username);
        dto.setPassword(password);
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setEmail(email);

        return dto;
    }

    public static User createUserObject(Long id, String username, String password, String firstName, String lastName,
                                        String email, List<Role> roles) {
        User user = new User();

        user.setId(id);
        user.setUserName(username);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setRoles(roles);

        return user;
    }
}
