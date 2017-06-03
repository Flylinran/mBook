package cn.flylinran.service.impl;

import cn.flylinran.dao.CategoryDao;
import cn.flylinran.model.Category;
import cn.flylinran.service.CategoryService;
import cn.flylinran.utils.UIDUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 图书类别业务接口实现类
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryDao categoryDao;

    @Override
    public List<Category> selectAll() {
        return categoryDao.selectAll();
    }

    @Override
    public Category selectByUid(String uid) {
        return categoryDao.selectByUid(uid);
    }

    @Transactional
    @Override
    public boolean insert(Category category) {
        category.setUid(UIDUtil.getRandomUID());
        return categoryDao.insert(category);
    }

    @Transactional
    @Override
    public boolean update(Category category) {
        return categoryDao.update(category);
    }

    @Transactional
    @Override
    public boolean deleteByUid(String uid) {
        return categoryDao.deleteByUid(uid);
    }

    @Transactional
    @Override
    public boolean delete(Category category) {
        return categoryDao.delete(category);
    }
}
