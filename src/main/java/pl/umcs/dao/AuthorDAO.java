package pl.umcs.dao;

import pl.umcs.entity.Author;

import java.util.List;

public interface AuthorDAO {
    public List<Author> getAuthors();

    public void saveAuthor(Author author);

    Author getAuthor(long authorId);

    void deleteAuthor(long authorId);
}
