package com.atguigu.spring5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.atguigu.spring5.entity.Book;

import java.util.Arrays;
import java.util.List;


@Repository
public class BookDaoImpl implements BookDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;


    // 新增记录
    @Override
    public void add(Book book) {

        // 创建 sql 语句
        String sql = "insert into t_book values (?, ?, ?)";

        // 调用实现方法
//        int rows = jdbcTemplate.update(sql, book.getUserId(), book.getUsername(), book.getUstatus());
        Object[] args = {book.getUserId(), book.getUsername(), book.getUstatus()};
        int rows = jdbcTemplate.update(sql, args);

        System.out.println(rows);
    }

    @Override
    public void updateBook(Book book) {
        String sql = "update t_book set username = ?, ustatus = ? where user_id = ?";
        Object[] args = {book.getUsername(), book.getUstatus(), book.getUserId()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println("update:-rows:" + update);
    }

    @Override
    public void deleteBook(String id) {
        String sql = "delete from t_book where user_id = ?";
        int rows = jdbcTemplate.update(sql, id);
        System.out.println("delete-rows: " + rows);

    }

    //
    @Override
    public int selectCount() {
        String sql = "select count(*) from t_book where user_id > ?";
        Object[] args = {"1"};
        Integer count = jdbcTemplate.queryForObject(sql, args, Integer.class);
        return count;
    }

    @Override
    public Book findBookInfo(String id) {
        String sql = "select * from t_book where user_id = ?";
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
        return book;
    }

    @Override
    public List<Book> getAll() {
        String sql = "select * from t_book";
        List<Book> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return list;
    }

    @Override
    public void batchAdd(List<Object[]> list) {
        String sql = "insert into t_book values (?, ?, ?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(ints));

    }

    @Override
    public void batchUpdate(List<Object[]> list) {
        String sql = "update t_book set username = ?, ustatus = ? where user_id = ?";
        int[] ints = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(ints));

    }

    @Override
    public void batchDelete(List<Object[]> list) {
        String sql = "delete from t_book where user_id = ?";
        int[] ints = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(ints));

    }
}
