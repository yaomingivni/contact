package model;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Liste {


	@GetMapping("/liste")
	 public String greeting(@RequestParam(required=false, defaultValue="World") String name, 	Model model ) {
	    	model.addAttribute("name", name);
	    	
	        return "liste";
	    }
}
