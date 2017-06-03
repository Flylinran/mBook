package cn.flylinran.service;

import cn.flylinran.BaseTest;
import cn.flylinran.model.Book;
import cn.flylinran.utils.UIDUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 图书测试
 */
public class BookServiceTest extends BaseTest {

    @Resource
    private BookService bookService;

    @Test
    public void selectAll() throws Exception {
        List<Book> books = bookService.selectAll();
        PageHelper.startPage(1, 5);
        PageInfo page = new PageInfo(books, 5);
        System.out.println(page);
    }

    @Test
    public void selectByUid() throws Exception {
        System.out.println(bookService.selectByUid("b27de23f882d4a78a2f586d3e08ba2d6"));
    }

    @Transactional
    @Test
    public void insert() throws Exception {
        Book book = new Book();
        String uid = UIDUtil.getRandomUID();
        System.out.println(uid);
        book.setUid(uid);
        book.setName("测试书籍");
        book.setAuthor("胡");
        book.setCategory(UIDUtil.getRandomUID());
        book.setPrice(10);
        book.setStock(10);
        book.setDescription("描述");
        System.out.println(bookService.insert(book));
    }

    @Transactional
    @Test
    public void update() throws Exception {
        Book book = bookService.selectByUid("a8ace607410d4c518b9b7231e7a1232b");
        book.setStock(20);
        System.out.println(bookService.update(book));
    }

    @Transactional
    @Test
    public void deleteByUid() throws Exception {
        System.out.println(bookService.deleteByUid("a8ace607410d4c518b9b7231e7a1232b"));
    }

    @Transactional
    @Test
    public void delete() throws Exception {
        System.out.println(bookService.delete(bookService.selectByUid("a8ace607410d4c518b9b7231e7a1232b")));
    }

}