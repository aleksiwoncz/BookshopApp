package pl.umcs.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.umcs.entity.Authority;
import pl.umcs.entity.User;
import pl.umcs.services.UserService;

@Controller
public class RegistrationController {
    private UserService userService;
//    @Autowired
//    public RegistrationController(UserService userService)
//    {
//        this.userService = userService;
//    }

    @Autowired
    public void setUserService(UserService userService) {
    this.userService = userService;
}

    @GetMapping(value = {"/register", "/adminregister"})
    public String registerForm(Model model)
    {
        model.addAttribute("user", new User());
        return "register";
    }
    @GetMapping("/user")
    public String user(User user)
    {
        return "user";
    }

    @GetMapping("/admin")
    public String admin(User user)
    {
        return "admin";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute("user") User user, Model model)
    {
        String info = info(user);
        if (!info.isEmpty()) {
            model.addAttribute("info", info);
            return "register";
        }
        user.getAuthorities().add(new Authority(user, "ROLE_USER"));
        userService.saveUser(user);
        return "redirect:/login";
    }
    @PostMapping("/adminregister")
    public String saveAdmin(@ModelAttribute("user") User user, Model model)
    {
        String info = info(user);
        if (!info.isEmpty()) {
            model.addAttribute("info", info);
            return "register";
        }
        user.getAuthorities().add(new Authority(user, "ROLE_USER"));
        user.getAuthorities().add(new Authority(user, "ROLE_ADMIN"));
        userService.saveUser(user);
        return "redirect:/login";
    }
    private String info(User user)
    {
        if (userService.getUser(user.getUsername()) != null) {
            return "u??ytkownik o takiej nazwie istnieje";
        } else if (user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
            return "wype??nij wszystkie pola";
        }
        return "";
    }
}