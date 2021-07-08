package pl.umcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.umcs.entity.Category;
import pl.umcs.services.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/adminlist")
    public String listCategory(Model model)
    {
        List<Category> result = categoryService.getCategories();
        model.addAttribute("categories", result);
        return "categories/adminlist";
    }

    @GetMapping("/adminadd")
    public String add(Model model) {
        Category category = new Category();
        List<Category> categories = categoryService.getCategories();
        model.addAttribute("category", category);
        return "categories/adminform";
    }

    @PostMapping("/adminadd")
    public String saveCategory(@ModelAttribute("category") Category category)
    {
        categoryService.saveCategory(category);
        return "redirect:/categories/adminlist";
    }

    @GetMapping("/adminedit")
    public String edit(@RequestParam("categoryId") int categoryId, Model model) {
        Category category = categoryService.getCategory(categoryId);
        model.addAttribute("category", category);
        return "categories/adminedit";
    }

    @GetMapping("/admindelete")
    public String delete(@RequestParam("categoryId") int categoryId) {
        categoryService.deleteCategory(categoryId);
        return "redirect:/categories/adminlist";
    }
}
