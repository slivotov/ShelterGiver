package ru.stason.study.spring.logic;

import ru.stason.study.spring.model.Spittle;

import java.util.List;

public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
    Spittle findOne(long spittleId);
}

