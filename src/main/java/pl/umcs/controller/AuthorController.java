package pl.umcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.umcs.entity.Author;
import pl.umcs.services.AuthorService;
import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private AuthorService authorService;

    @Autowired
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/adminlist")
    public String listAuthor(Model model)
    {
        List<Author> result = authorService.getAuthors();
        model.addAttribute("authors", result);
        return "authors/adminlist";
    }

    @GetMapping("/adminadd")
    public String add(Model model) {
        Author author = new Author();
        model.addAttribute("author", author);
        return "authors/adminform";
    }

    @PostMapping("/adminadd")
    public String saveAuthor(@ModelAttribute("author") Author author)
    {
        authorService.saveAuthor(author);
        return "redirect:/authors/adminlist";
    }

    @GetMapping("/adminedit")
    public String edit(@RequestParam("authorId") int authorId, Model model) {
        Author author = authorService.getAuthor(authorId);
        model.addAttribute("author", author);
        return "authors/adminedit";
    }

    @GetMapping("/admindelete")
    public String delete(@RequestParam("authorId") int authorId) {
        authorService.deleteAuthor(authorId);
        return "redirect:/authors/adminlist";
    }
}