package pl.umcs.dao;

import pl.umcs.entity.Book;

import java.util.List;

public interface BookDAO {
    public List<Book> getBooks();

    public void saveBook(Book book);

    Book getBook(long bookId);

    void deleteBook(long bookId);
}

