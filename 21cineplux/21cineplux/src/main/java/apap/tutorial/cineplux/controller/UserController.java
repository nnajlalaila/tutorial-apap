package apap.tutorial.cineplux.controller;
import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.RoleModel;
import apap.tutorial.cineplux.model.UserModel;
import apap.tutorial.cineplux.service.RoleService;
import apap.tutorial.cineplux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/add")
    private String addUserFormPage(Model model){
        UserModel user = new UserModel();
        List<RoleModel> listRole = roleService.getListRole();
        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        return "form-add-user" ;
    }

    @PostMapping(value = "/add")
    private String addUserSubmit(@ModelAttribute UserModel user, Model model,  RedirectAttributes attributes) {
        List<UserModel> allUser = userService.getListUser();
        for (UserModel userLama :allUser
             ) {
            if (user.getEmail().equals(userLama.getEmail())){
                attributes.addFlashAttribute("notif", "Email yang anda masukkan sudah digunakan");
                return "redirect:/user/add";
            }
        }
        userService.addUser (user);
        model.addAttribute("user", user);
        return "redirect:/";
    }

    @GetMapping("/viewall")
    public String listBioskop(Model model) {
        List<UserModel> listUser = userService.getListUser();
        model.addAttribute ( "listUser",listUser);
        return "view-all-user" ;
    }

    @GetMapping("/delete/{idUser}")
    public String deleteUserForm(
            @PathVariable String idUser,
            Model model
    ) {
        UserModel user = userService.getUserById(idUser);
        if (user != null) {
            userService.deleteUser(user);
            model.addAttribute("idUser", idUser);
            return "delete-user";
        } else {
            model.addAttribute("idUser", idUser);
            return "delete-id-not-found";
        }
    }
    @RequestMapping(value = "/update-password", method = RequestMethod.GET)
    private String updatePasswordForm(){
        return "update-password";
    }

    @RequestMapping(value = "/update-password", method = RequestMethod.POST)
    private String changePasswordSubmit(
            @RequestParam(value = "passwordOld") String passwordOld,
            @RequestParam(value = "passwordNew") String passwordNew,
            @RequestParam(value = "passwordNew2") String passwordNew2,
            HttpServletRequest request,
            RedirectAttributes attributes,
            Model model
    ) {
        Principal principal = request.getUserPrincipal();
        UserModel user = userService.getUserByUsername(principal.getName());
        if(!passwordNew.equals(passwordNew2)){
            model.addAttribute("notif", "Password baru tidak match, mohon input ulang");
            return "update-password";
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if(passwordEncoder.matches(passwordOld, user.getPassword())){
            String a = userService.changePassword(user, passwordNew);
            attributes.addFlashAttribute("notif", a);
            return "redirect:/user/update-password";
        }
        else{
            model.addAttribute("notif", "Password lama salah, mohon input ulang");
            return "update-password";
        }
    }

}
