package pl.umcs.services;

import pl.umcs.entity.Author;
import java.util.List;

public interface AuthorService {
    List<Author> getAuthors();

    void saveAuthor(Author author);

    Author getAuthor(long authorId);

    void deleteAuthor(long authorId);
}