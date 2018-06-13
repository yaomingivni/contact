package model;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;


@Controller
public class WebController {

	private AddContact contactForm= new AddContact();
	
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/listerContact")
    public String showForm2() {
    	return "liste";
    }
    @ModelAttribute("contactForm")
    public AddContact getContact() {
        return contactForm;
    }

    @RequestMapping(value = "/modifier/{id}", method = RequestMethod.POST)
    public String modifierContact(Model model ,@PathVariable("id") long id) {
    	model.addAttribute("contactForm", this.interfaceContact.findById(id) );
    	
		return "addContact";
    	
    }
   
    @RequestMapping(value = "/supprimer/{id}", method = RequestMethod.POST)
    public String supprimerContact(@PathVariable("id") long id) {
    	
    	this.interfaceContact.delete(id);
		return "redirect:/liste";
    	
    }
    
    @GetMapping("/ajouter")
    public String ajouter() {
    	return "addContact";
    }
    
    @Autowired
    private AddContactRepository interfaceContact;
    
    @PostMapping("/tryAjouter")
    public String checkPersonInfo(@Valid AddContact contactForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "addContact";
        }
        this.interfaceContact.save(contactForm);
        return "redirect:/liste";
    }

	
}