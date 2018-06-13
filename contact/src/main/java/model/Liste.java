package model;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Liste {


	@GetMapping("/liste")
	 public String greeting(@RequestParam(required=false, defaultValue="World") String name, 	Model model ) {
	    	model.addAttribute("name", name);
	    	model.addAttribute("Personne", getListContact());
	        return "liste";
	    }
	
	@Autowired
    private AddContactRepository interfaceContact;
	
	public List<AddContact> getListContact(){
		
		List<AddContact> pers = new ArrayList<AddContact>();
		this.interfaceContact.findAll().forEach(pers::add);
		
		return pers;
	}
}
