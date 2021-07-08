package pl.umcs.entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "kategorie")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nazwa")
    private String name;
    @OneToMany(targetEntity = Book.class, mappedBy = "category", cascade = CascadeType.ALL)
    List<Book> books;

    public Category() {
        this.books = new ArrayList<>();
    }

    public Category(String id) {
        this.id = Long.parseLong(id);

    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nazwa) {
        this.name = nazwa;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        if (books == null) {
            books = new ArrayList<>();
        }
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }
}