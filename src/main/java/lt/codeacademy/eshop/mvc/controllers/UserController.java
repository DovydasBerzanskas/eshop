package lt.codeacademy.eshop.mvc.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lt.codeacademy.eshop.common.user.dto.UserDto;
import lt.codeacademy.eshop.common.user.service.UsersRegistrationService;
import lt.codeacademy.eshop.common.user.service.UsersService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UsersService usersService;
    private final UsersRegistrationService usersRegistrationService;

    @GetMapping("/create")
    public String getUserForm(Model model) {
        model.addAttribute("userDto", UserDto.builder().build());
        log.info("Got a GET /users/create");

        return "user/user";
    }

    @PostMapping("/create")
    public String register(Model model, @Valid UserDto userDto, BindingResult errors) {
        if (errors.hasErrors()) {
            return "user/user";
        }
        try {
            usersRegistrationService.register(userDto);
        } catch (DataIntegrityViolationException e) {
            if (e.getMessage().contains("EMAIL")) {
                errors.rejectValue("email", "This email is already used!");
            }
        }

        return "redirect:/users/create";
    }
}
