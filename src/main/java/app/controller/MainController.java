package app.controller;

import app.model.Role;
import app.model.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;

    @GetMapping
    public String greeting(ModelMap model) {
        return "greeting";
    }

    @GetMapping("/admin")
    public String main(ModelMap model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin";
    }

    @GetMapping("/admin/add")
    public String getAdd(ModelMap model) {
        model.addAttribute("u_role", Role.USER);
        model.addAttribute("a_role", Role.ADMIN);
        return "add";
    }

    @PostMapping("/admin/add")
    public String postAdd(@RequestParam(name = "firstName") String firstName,
                          @RequestParam(name = "lastName") String lastName,
                          @RequestParam(name = "lastName") String password,
                          @RequestParam(name = "bankAcc") long bankAcc,
                          @RequestParam(name = "email") String email,
                          @RequestParam(name = "user_role", required = false) Role roleUser,
                          @RequestParam(name = "admin_role", required = false) Role roleAdmin) {

        Set<Role> roles = new HashSet<>();
        roles.add(roleUser);
        roles.add(roleAdmin);

        User user = new User(firstName, lastName, password, bankAcc, email, roles);
        userService.addUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/admin/update")
    public String getUpdate(ModelMap model) {
        model.addAttribute("u_role", Role.USER);
        model.addAttribute("a_role", Role.ADMIN);
        return "update";
    }

    @PostMapping("/admin/update")
    public String postUpdate(@RequestParam(name = "id") long id,
                             @RequestParam(name = "firstName") String firstName,
                             @RequestParam(name = "lastName") String lastName,
                             @RequestParam(name = "lastName") String password,
                             @RequestParam(name = "bankAcc") long bankAcc,
                             @RequestParam(name = "email") String email,
                             @RequestParam(name = "user_role", required = false) Role roleUser,
                             @RequestParam(name = "admin_role", required = false) Role roleAdmin) {

        Set<Role> roles = new HashSet<>();
        roles.add(roleUser);
        roles.add(roleAdmin);

        User user = new User(firstName, lastName, password, bankAcc, email, roles);
        userService.updateUser(id, user);
        return "redirect:/admin";
    }

    @PostMapping("/admin/delete")
    public String delete(@RequestParam long id) {
        userService.removeUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/user")
    public String user(ModelMap model) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "user";
    }
}
