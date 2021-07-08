package pl.umcs.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.umcs.entity.Author;

import java.util.List;

@Repository
public class AuthorDAOImpl implements AuthorDAO{
    private SessionFactory sessionFactory;

    @Autowired
    public AuthorDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Author> getAuthors() {
        //sesja hibertabe
        Session currentSession = sessionFactory.getCurrentSession();
        //zapytanie
        Query<Author> query = currentSession.createQuery(" from Author", Author.class);
        List<Author> authors = query.getResultList();
        return authors ;
    }

    @Override
    public void saveAuthor(Author author) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(author);
    }

    @Override
    public Author getAuthor(long authorId) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Author.class, authorId);
    }

    @Override
    public void deleteAuthor(long authorId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("DELETE FROM Author WHERE id = :id");
        query.setParameter("id", authorId);
        query.executeUpdate();
    }
}
