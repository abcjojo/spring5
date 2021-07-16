package com.atguigu.spring5.service;

import com.atguigu.spring5.dao.BookDao;
import com.atguigu.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {

    // 注入dao
    @Autowired
    private BookDao bookDao;

    // 添加方法
    public void addBook(Book book) {
        bookDao.add(book);
    }

    // 修改
    public void update(Book book) {
        bookDao.updateBook(book);
    }

    // 删除
    public void delete(String id) {
        bookDao.deleteBook(id);
    }

    // 查询表记录数
    public int selectCount() {
        return bookDao.selectCount();
    }


    // 查询表记录
    public Book getOne(String id) {
        return bookDao.findBookInfo(id);
    }

    // 获取集合
    public List<Book> getAll() {
        return bookDao.getAll();
    }

    // 批量添加
    public void batchAdd(List<Object[]> list) {
        bookDao.batchAdd(list);
    }

    // 批量更新
    public void batchUpdate(List<Object[]> list) {
        bookDao.batchUpdate(list);
    }

    // 批量删除
    public void batchDelete(List<Object[]> list) {
        bookDao.batchDelete(list);
    }
}
