package cn.flylinran.service;

import cn.flylinran.model.Book;

import java.util.List;

/**
 * 图书业务接口
 */
public interface BookService {

    List<Book> selectAll();

    Book selectByUid(String uid);

    boolean insert(Book book);

    boolean update(Book book);

    boolean deleteByUid(String uid);

    boolean delete(Book book);
}
