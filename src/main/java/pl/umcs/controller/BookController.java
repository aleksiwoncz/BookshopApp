package pl.umcs.controller;
import org.springframework.web.bind.annotation.*;
import pl.umcs.entity.Book;
import pl.umcs.entity.Category;
import pl.umcs.services.CategoryService;
import pl.umcs.services.AuthorService;
import pl.umcs.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private BookService bookService;
    private CategoryService categoryService;
    private AuthorService authorService;

//    @Autowired
//    public BookController(BookService bookService)
//    {
//        this.bookService = bookService;
//    }
    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @Autowired
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/list")
    public String listBook(Model model)
    {
        List<Book> result = bookService.getBooks();
        model.addAttribute("books", result);
        return "books/list";
    }

    @GetMapping("/adminlist")
    public String adminListBook(Model model)
    {
        List<Book> result = bookService.getBooks();
        model.addAttribute("books", result);
        return "books/adminlist";
    }

    @GetMapping("/adminadd")
    public String add(Model model) {
        Book book = new Book();
        List<Category> categories = categoryService.getCategories();
        model.addAttribute("book", book);
        model.addAttribute("categories", categories);
        model.addAttribute("authors", authorService.getAuthors());
        return "books/adminform";
    }

    @PostMapping("/adminadd")
    public String saveBook(@ModelAttribute("book") Book book)
    {
        bookService.saveBook(book);
        return "redirect:/books/adminlist";
    }

    @GetMapping("/adminedit")
    public String edit(@RequestParam("bookId") int bookId, Model model) {
        Book book = bookService.getBook(bookId);
        List<Category> categories = categoryService.getCategories();
        model.addAttribute("book", book);
        model.addAttribute("categories", categories);
        model.addAttribute("authors", authorService.getAuthors());
        return "books/adminedit";
    }

    @GetMapping("/admindelete")
    public String delete(@RequestParam("bookId") int bookId) {
        bookService.deleteBook(bookId);
        return "redirect:/books/adminlist";
    }

}