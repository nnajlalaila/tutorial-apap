package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.RoleModel;
import apap.tutorial.cineplux.model.UserModel;
import apap.tutorial.cineplux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class PageController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home(HttpServletRequest request, Model model){

        Principal principal = request.getUserPrincipal();
        UserModel user = userService.getUserByUsername(principal.getName());
        RoleModel role = user.getRole();
        model.addAttribute("role", role.getRole());
        return "home";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
