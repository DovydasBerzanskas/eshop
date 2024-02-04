package lt.codeacademy.eshop.product.controllers;

import jakarta.validation.Valid;
import lt.codeacademy.eshop.product.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/create")
    public String getUserForm(Model model) {
        model.addAttribute("userDto", UserDto.builder().build());
        return "user/user";
    }

    @PostMapping("/create")
    public String register(Model model, @Valid UserDto userDto, BindingResult errors) {
        if (errors.hasErrors()) {
            return "user/user";
        }
        System.out.println("Registration request successful");
        System.out.println(userDto);

        return "redirect:/user/create";
    }
}
