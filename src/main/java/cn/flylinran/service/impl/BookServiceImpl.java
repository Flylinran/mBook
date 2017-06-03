package cn.flylinran.service.impl;

import cn.flylinran.dao.BookDao;
import cn.flylinran.model.Book;
import cn.flylinran.service.BookService;
import cn.flylinran.utils.UIDUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookDao bookDao;

    @Override
    public List<Book> selectAll() {
        return bookDao.selectAll();
    }

    @Override
    public Book selectByUid(String uid) {
        return bookDao.selectByUid(uid);
    }

    @Transactional
    @Override
    public boolean insert(Book book) {
        book.setUid(UIDUtil.getRandomUID());
        return bookDao.insert(book);
    }

    @Transactional
    @Override
    public boolean update(Book book) {
        return bookDao.update(book);
    }

    @Transactional
    @Override
    public boolean deleteByUid(String uid) {
        return bookDao.deleteByUid(uid);
    }

    @Transactional
    @Override
    public boolean delete(Book book) {
        return bookDao.delete(book);
    }
}
