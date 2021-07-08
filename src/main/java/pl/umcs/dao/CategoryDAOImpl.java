package pl.umcs.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.umcs.entity.Category;

import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO{
    private SessionFactory sessionFactory;

    //automatyczne wykorzystanie beana sessionFactory
    @Autowired
    public CategoryDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Category> getCategories() {
        //sesja hibertabe
        Session currentSession = sessionFactory.getCurrentSession();
        //zapytanie
        Query<Category> query = currentSession.createQuery(" from Category", Category.class);
        List<Category> categories = query.getResultList();
        return categories ;
    }

    @Override
    public void saveCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(category);
    }

    @Override
    public Category getCategory(long categoryId) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Category.class, categoryId);
    }

    @Override
    public void deleteCategory(long categoryId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("DELETE FROM Category WHERE id = :id");
        query.setParameter("id", categoryId);
        query.executeUpdate();
    }
}
