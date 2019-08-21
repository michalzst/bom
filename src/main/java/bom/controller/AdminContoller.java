package bom.controller;

import bom.dto.UserDto;
import bom.service.UserService;
import bom.user.RoleTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminContoller {

    @Autowired
    UserService userService;

    @GetMapping
    public String logged(Model model){
        model.addAttribute("info", "dla admina");
        return "admin";
    }
    @GetMapping(value = "/adduser")
    public String addTripForm(Model model) {
        model.addAttribute("userFormData", new UserDto());
        model.addAttribute("roleEnums", RoleTypeEnum.values());
        return "addUserForm";
    }

    @PostMapping(value = "/adduser")
    public String addTrip(@ModelAttribute(name = "userFormData") @Valid UserDto user, BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("roleEnums",  RoleTypeEnum.values());
            return "addUserForm";
        }

        userService.updateUser(user);
        model.addAttribute("addUserData", user.getLogin());
        return "addUserEffect";
    }

}

