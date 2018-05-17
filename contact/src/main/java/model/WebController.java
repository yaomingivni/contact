package model;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Controller
public class WebController  {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/")
    public String showForm(AddContact contactForm) {
        return "addContact";
    }

    @PostMapping("/")
    public String checkPersonInfo(@Valid AddContact contactForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "addContact";
        }

        return "redirect:/results";
    }
}