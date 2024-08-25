package br.edu.ifsuldeminas.mch.eventcrudmanager.controller;

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

import br.edu.ifsuldeminas.mch.eventcrudmanager.repo.EventRepository;
import jakarta.validation.Valid;
import br.edu.ifsuldeminas.mch.eventcrudmanager.model.Event;

@Controller
public class EventController {

	@Autowired
	private EventRepository eventRepository;

	@GetMapping("/events")
	public String listEvents(Model model) {
		List<Event> events = eventRepository.findAll();

		model.addAttribute("events", events);
		return "events";
	}

	@GetMapping("/events/form")
	public String eventForm(@ModelAttribute("event") Event event) {
		return "event_form";
	}

	@PostMapping("/events/register")
	public String eventNew(@Valid @ModelAttribute("event") Event event,
			BindingResult erros) {

		if (erros.hasErrors()) {
			return "event_form";
		}

		eventRepository.save(event);

		return "redirect:/events";
	}

	@GetMapping("/events/update/{id}")
	public String eventUpdate(@PathVariable("id") Integer id,
			Model model) {

		Optional<Event> eventOpt = eventRepository.findById(id);
		Event event = eventOpt.orElse(new Event());


		model.addAttribute("event", event);

		return "event_form";
	}

	@GetMapping("/events/delete/{id}")
	public String eventDelete(@PathVariable("id") Integer id) {

		eventRepository.delete(new Event(id));

		return "redirect:/events";
	}
}
