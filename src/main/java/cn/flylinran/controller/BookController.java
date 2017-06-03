package cn.flylinran.controller;

import cn.flylinran.model.Book;
import cn.flylinran.model.Category;
import cn.flylinran.service.BookService;
import cn.flylinran.service.CategoryService;
import cn.flylinran.vo.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 图书Controller
 */
@Controller
@RequestMapping("/")
public class BookController {

    @Resource
    private BookService bookService;

    @Resource
    private CategoryService categoryService;

    /**
     * 首页
     *
     * @return 首页视图
     */
    @RequestMapping
    public String index() {
        return "index";
    }

    /**
     * 图书列表
     *
     * @param pn            页码
     * @param pageSize      页大小
     * @param navigatePages 导航条栏数
     * @return 自定义响应实体 {@link Msg}
     */
    @ResponseBody
    @RequestMapping(value = "/book/list", method = RequestMethod.GET)
    public Msg showAll(@RequestParam(defaultValue = "1") Integer pn,
                       @RequestParam(defaultValue = "7") Integer pageSize,
                       @RequestParam(defaultValue = "5") Integer navigatePages) {

        PageHelper.startPage(pn, pageSize);
        List<Book> allBook = bookService.selectAll();
        PageInfo<Book> page = new PageInfo(allBook, navigatePages);
        return Msg.success().add("page", page);
    }

    /**
     * 图书详情
     *
     * @param uid 图书uid
     * @return 自定义响应实体 {@link Msg}
     */
    @ResponseBody
    @RequestMapping(value = "/book/{uid}", method = RequestMethod.GET)
    public Msg detail(@PathVariable String uid) {

        Book book = bookService.selectByUid(uid);
        return Msg.success().add("book", book);
    }

    /**
     * 图书上传
     *
     * @param book 图书实体，spring自动封装
     * @return 自定义响应实体 {@link Msg}
     */
    @ResponseBody
    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public Msg add(Book book) {

        boolean flag = bookService.insert(book);
        if (flag) {
            return Msg.success().setMessage("添加成功");
        }
        return Msg.fail().setMessage("添加失败");
    }

    /**
     * 图书信息修改
     *
     * @param book 图书实体，spring自动封装
     * @return 自定义响应实体 {@link Msg}
     */
    @ResponseBody
    @RequestMapping(value = "/book", method = RequestMethod.PUT)
    public Msg update(Book book) {

        boolean flag = bookService.update(book);
        if (flag) {
            return Msg.success().setMessage("更新成功");
        }
        return Msg.fail().setMessage("更新失败");
    }

    /**
     * 图书删除
     *
     * @param uid 图书uid
     * @return 自定义响应实体 {@link Msg}
     */
    @ResponseBody
    @RequestMapping(value = "/book/{uid}", method = RequestMethod.DELETE)
    public Msg delete(@PathVariable String uid) {

        boolean flag = bookService.deleteByUid(uid);
        if (flag) {
            return Msg.success().setMessage("删除成功");
        }
        return Msg.fail().setMessage("删除失败");
    }

    /**
     * 查询所有图书类别
     *
     * @return 自定义响应实体 {@link Msg}
     */
    @ResponseBody
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public Msg showCategory() {

        List<Category> categories = categoryService.selectAll();
        return Msg.success().add("categories", categories);
    }

    /**
     * 查询具体图书类别
     *
     * @param uid 类别uid
     * @return 自定义响应实体 {@link Msg}
     */
    @ResponseBody
    @RequestMapping(value = "/category/{uid}", method = RequestMethod.GET)
    public Msg categoryDetail(@PathVariable String uid) {

        Category category = categoryService.selectByUid(uid);
        return Msg.success().add("category", category);
    }

    /**
     * 基于@ExceptionHandler异常处理
     *
     * @param ex 捕获的异常
     * @return 自定义响应实体 {@link Msg}
     */
    @ExceptionHandler
    @ResponseBody
    public Msg exp(Exception ex) {
        return Msg.fail().setMessage("出现异常了");
    }
}
