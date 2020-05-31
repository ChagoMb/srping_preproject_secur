package app.controller;

import app.model.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    private HttpServletRequest request;

    private UserService userService;

    @Autowired
    @Qualifier(value = "userServiceImp")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    @Qualifier(value = "getRequest")
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    @GetMapping("/login")
    public String redirectToStartPage() {
        HttpSession session = request.getSession();
        session.invalidate();
        return "start";
    }

    @GetMapping("/login/begin")
    public String loginPage() {
        HttpSession session = request.getSession();

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        User user = this.userService.findUserByAuth(login, password);
        if (user.getId() == 0L) {
            return "error";
        }
        session.setAttribute("role", user.getRole());
        session.setAttribute("user", user);

        if ("user".equalsIgnoreCase(user.getRole())) {
            return "redirect:/user";
        } else if ("admin".equalsIgnoreCase(user.getRole())) {
            return "redirect:/admin";
        }
        return "start";
    }

    @GetMapping("/admin")
    public String redirectToAdminPage(ModelMap model) {
        List<User> users = userService.getAllUsers();

        String role = getSessionAttributeRole();

        if ("admin".equalsIgnoreCase(role)) {
            model.addAttribute("users", users);
            return "admin";
        } else if ("user".equalsIgnoreCase(role)) {
            return "user";
        } else {
            return "error";
        }
    }

    @PostMapping("/admin/add")
    public String add() {
        if ("admin".equalsIgnoreCase(getSessionAttributeRole())) {
            User user = getUserByRequestParams();
            userService.addUser(user);

            return "redirect:/admin";
        }
        return "start";
    }

    @GetMapping("/admin/add")
    public String redirectToAdd() {
        if ("admin".equalsIgnoreCase(getSessionAttributeRole())) {
            return "add";
        }
        return "start";
    }

    @PostMapping("/admin/update")
    public String update() {
        if ("admin".equalsIgnoreCase(getSessionAttributeRole())) {
            long id = Long.parseLong(request.getParameter("id"));
            User user = getUserByRequestParams();
            userService.updateUser(id, user);

            return "redirect:/admin";
        }
        return "start";
    }

    @GetMapping("/admin/update")
    public String redirectToUpdate() {
        if ("admin".equalsIgnoreCase(getSessionAttributeRole())) {
            return "update";
        }
        return "start";
    }

    @PostMapping("/admin/delete")
    public String delete() {
        if ("admin".equalsIgnoreCase(getSessionAttributeRole())) {
            long id = Long.parseLong(request.getParameter("id"));
            userService.removeUser(id);

            return "redirect:/admin";
        }
        return "start";
    }

    @GetMapping("/user")
    public String redirectToUser(ModelMap model) {
        HttpSession session = request.getSession();
        if (session.getAttribute("role") == null) {
            return "error";
        }
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "user";
    }

    @Bean(name = "getRequest")
    public HttpServletRequest getRequest(HttpServletRequest request) {
        return request;
    }

    public User getUserByRequestParams() {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        long bankAcc = Long.parseLong(request.getParameter("bankAcc"));
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        return new User(firstName, lastName, password, bankAcc, email, role);
    }

    public String getSessionAttributeRole() {
        HttpSession session = request.getSession();
        if (session.getAttribute("role") == null) {
            return "start";
        }
        return (String) session.getAttribute("role");
    }
}
