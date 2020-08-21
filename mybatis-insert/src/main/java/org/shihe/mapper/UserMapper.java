package org.shihe.mapper;

import org.shihe.model.User;

public interface UserMapper {
    User getUserById(Long id);
    void addUser(User user);
}
