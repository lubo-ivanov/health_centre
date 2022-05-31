package projects.healthcentre.web.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import projects.healthcentre.model.dto.SignUpInputDto;

import javax.validation.Valid;
import javax.validation.Validator;

@Controller
@RequestMapping("/")
public class SignUpController {
    private final Validator validator;

    @Autowired
    public SignUpController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping
    private ModelAndView signUp() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index.html");
        return mav;
    }

    @PostMapping
    private String createUser(@Valid SignUpInputDto signUpInputDto, BindingResult bindingResult) {
        if (!validator.validate(signUpInputDto).isEmpty()) {
            return "index";
        }
        if (bindingResult.hasErrors()) {
            return "index";
        }

        //TODO: return something proper
        return "success";
    }

}
