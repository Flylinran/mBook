package cn.flylinran.service;

import cn.flylinran.model.Category;

import java.util.List;

/**
 * 图书类别业务接口
 */
public interface CategoryService {

    List<Category> selectAll();

    Category selectByUid(String uid);

    boolean insert(Category category);

    boolean update(Category category);

    boolean deleteByUid(String uid);

    boolean delete(Category category);
}
