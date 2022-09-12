package com.stars.pratise.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IService<T> {

    List<T> selectAll();

    T selectByKey(Object key);

    int save(T entity);

    int delete(Object key);

    int updateAll(T entity);

    int updateNotNull(T entity);

    List<T> selectByExample(Object example);

}
