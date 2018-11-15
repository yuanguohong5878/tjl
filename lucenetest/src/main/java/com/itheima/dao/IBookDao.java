package com.itheima.dao;

import com.itheima.entity.Book;

import java.util.List;

public interface IBookDao {
    List<Book> findAll();
}
