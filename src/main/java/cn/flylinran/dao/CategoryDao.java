package cn.flylinran.dao;

import cn.flylinran.model.Category;

import java.util.List;

/**
 * 图书类别DAO
 */
public interface CategoryDao {

    List<Category> selectAll();

    Category selectByUid(String uid);

    boolean insert(Category category);

    boolean update(Category category);

    boolean deleteByUid(String uid);

    boolean delete(Category category);
}
