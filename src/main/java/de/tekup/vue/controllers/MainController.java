package de.tekup.vue.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import de.tekup.vue.models.dto.User;
import de.tekup.vue.services.UserRestService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MainController {
	private UserRestService service;
	// preparing the Form
	@GetMapping("/register")
	public String showForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		
		return "register_form";
	}
	
	// Collect data from Form
	@PostMapping("/register")
	public String submitForm(@ModelAttribute("user") User userRequest) {
		service.sendUserToDB(userRequest);
		return "register_success";
	}

}
