package cn.flylinran.service;

import cn.flylinran.BaseTest;
import cn.flylinran.model.Category;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 图书类别测试
 */
public class CategoryServiceTest extends BaseTest {

    @Resource
    private CategoryService categoryService;

    @Test
    public void selectAll() throws Exception {
        Assert.assertEquals(3, categoryService.selectAll().size());
    }

    @Test
    public void selectByUid() throws Exception {
        System.out.println(categoryService.selectByUid("15b7d6aa8f6c4b15be5ec58e0fc690b2"));
    }

    @Transactional
    @Test
    public void insert() throws Exception {
        Category category = new Category();
        category.setDescription("历史");

        System.out.println(categoryService.insert(category));
    }

    @Transactional
    @Test
    public void update() throws Exception {
        Category category = categoryService.selectByUid("15b7d6aa8f6c4b15be5ec58e0fc690b2");
        category.setDescription("历史");
        System.out.println(categoryService.update(category));
    }

    @Transactional
    @Test
    public void deleteByUid() throws Exception {
        System.out.println(categoryService.deleteByUid("15b7d6aa8f6c4b15be5ec58e0fc690b2"));
    }

    @Transactional
    @Test
    public void delete() throws Exception {
        Category category = categoryService.selectByUid("15b7d6aa8f6c4b15be5ec58e0fc690b2");
        System.out.println(categoryService.delete(category));
    }

}