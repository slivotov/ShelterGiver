package ru.stason.study.spring.model.dao;

import ru.stason.study.spring.persist.entities.User;

import java.util.List;

public interface UserDAO {
    List<User> list();

    User getById(int id);

    User getByName(String name);

    void saveOrUpdate(User user);

    void delete(int id);
}
