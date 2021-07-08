package pl.umcs.dao;

import pl.umcs.entity.Category;
import java.util.List;

public interface CategoryDAO {
    public List<Category> getCategories();

    public void saveCategory(Category category);

    Category getCategory(long categoryId);

    void deleteCategory(long categoryId);

}
