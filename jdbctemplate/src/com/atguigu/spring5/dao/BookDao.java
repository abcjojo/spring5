package com.atguigu.spring5.dao;

import com.atguigu.spring5.entity.Book;

import java.util.List;

public interface BookDao {
    void add(Book book);

    void updateBook(Book book);

    void deleteBook(String id);

    int selectCount();


    Book findBookInfo(String id);

    List<Book> getAll();

    void batchAdd(List<Object[]> list);

    void batchUpdate(List<Object[]> list);

    void batchDelete(List<Object[]> list);
}
