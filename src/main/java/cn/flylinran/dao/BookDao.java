package cn.flylinran.dao;

import cn.flylinran.model.Book;

import java.util.List;

public interface BookDao {

    List<Book> selectAll();

    Book selectByUid(String uid);

    boolean insert(Book book);

    boolean update(Book book);

    boolean deleteByUid(String uid);

    boolean delete(Book book);

}