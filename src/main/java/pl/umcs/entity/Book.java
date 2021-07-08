package pl.umcs.entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ksiazki")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nazwa")
    private String title;
    @Column(name = "wydawnictwo")
    private String publisher;
    @Column(name = "cena")
    private Float price;
    @ManyToOne(targetEntity = Category.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "kategoria_id")
    private Category category;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "autorzy_to_ksiazki",
            joinColumns = @JoinColumn(name = "ksiazka_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id"))
    List<Author> authors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String nazwa) {
        this.title = nazwa;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String wydawnictwo) {
        this.publisher = wydawnictwo;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(float cena) {
        this.price = cena;
    }

    public List<Author> getAuthors() {
        return authors;
    }
    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void addAuthor(Author author) {
        if (author == null) {
            authors = new ArrayList<>();
        }
        authors.add(author);
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void removeAuthor(Author author)
    {
        authors.remove(author);
    }
}