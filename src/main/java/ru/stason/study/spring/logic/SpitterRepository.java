package ru.stason.study.spring.logic;

import ru.stason.study.spring.model.Spitter;

public interface SpitterRepository {
    Spitter save(Spitter spitter);
    Spitter findByUsername(String username);
}
