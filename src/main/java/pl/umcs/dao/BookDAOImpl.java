package pl.umcs.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.umcs.entity.Book;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {
    //automatyczne wykorzystanie beana sessionFactory
    private SessionFactory sessionFactory;

    @Autowired
    public BookDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    //pobranie i zwrocenie wszystkich ksiazek z bazy za pomoca zapytania HQL:
    public List<Book> getBooks() {
        //sesja hibertabe
        Session currentSession = sessionFactory.getCurrentSession();
        //zapytanie
        Query<Book> query = currentSession.createQuery(" from Book", Book.class);
        List<Book> books = query.getResultList();
        return books ;
    }

    @Override//zapis ksiazki do bazy:
    public void saveBook(Book book) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(book);
    }

    @Override
    public Book getBook(long bookId) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Book.class, bookId);
    }

    @Override
    public void deleteBook(long bookId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("DELETE FROM Book WHERE id = :id");
        query.setParameter("id", bookId);
        query.executeUpdate();
    }
}

