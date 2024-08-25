package br.edu.ifsuldeminas.mch.webii.crudmanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.User;
import br.edu.ifsuldeminas.mch.webii.crudmanager.repo.AddressRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.repo.UserRepository;
import jakarta.validation.Valid;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	AddressRepository addressRepository;

	@GetMapping("/users")
	public String listUsers(Model model) {

		List<User> users = userRepository.findAll();

		model.addAttribute("users", users);

		return "index";
	}

	@GetMapping("/users/form")
	public String userForm(@ModelAttribute("user") User user) {
		// ESTUDAR BINDING DO SPRING

		return "users_form";
	}

	@PostMapping("/users/register")
	public String userNew(@Valid @ModelAttribute("user") User user, BindingResult errors) {

		if (errors.hasErrors()) {
			return "users_form";
		}

		addressRepository.save(user.getAddress());
		userRepository.save(user);

		return "redirect:/users";
	}

	@GetMapping("/users/update/{id}")
	public String userUpdate(@PathVariable("id") Integer id, Model model) {

		Optional<User> userOpt = userRepository.findById(id);
		User user;

		if (!userOpt.isPresent()) {
			user = new User();
		}

		user = userOpt.get();

		model.addAttribute(user);
		return "users_form";
	}

	@GetMapping("/users/delete/{id}")
	public String userDelete(@PathVariable("id") Integer id) {

		userRepository.delete(new User(id));
		return "redirect:/users";
	}
}
