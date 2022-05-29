package projects.healthcentre.web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("/")
public class HomeController {

    @GetMapping
    private ModelAndView signUp () {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }
}
