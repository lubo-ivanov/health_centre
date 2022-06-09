package projects.healthcentre.web.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import projects.healthcentre.model.dto.SignUpInputDto;
import projects.healthcentre.util.ValidationUtil;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class SignUpController {
    private final ValidationUtil validationUtil;

    @Autowired
    public SignUpController(ValidationUtil validationUtil) {
        this.validationUtil = validationUtil;
    }

    @GetMapping
    private ModelAndView signUp() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index.html");
        return mav;
    }

    @PostMapping
    private String createUser(@Valid SignUpInputDto signUpInputDto, BindingResult bindingResult) {
        if (!validationUtil.isValid(signUpInputDto)) {
            return "index";
        }
        if (bindingResult.hasErrors()) {
            return "index";
        }
        return "success";
    }

}
