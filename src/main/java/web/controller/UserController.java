package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.service.UserService;
import web.model.User;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String users(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users/index";
    }

    @GetMapping("/user")
    public String getUser(@ModelAttribute("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/user";
    }


    @GetMapping("/new")
    public String addUser(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping()
    public String add(@ModelAttribute("user") User user) {
            userService.addUser(user);
            return "redirect:/users";
    }


    @GetMapping("/edit")
    public String edit (@ModelAttribute("id") int id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "users/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("id") long id, User user) {
        user.setUserId(id);
        userService.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("id") int id) {
        userService.removeUser(id);
        return "redirect:/users";
    }

}
