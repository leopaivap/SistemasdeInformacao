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

import br.edu.ifsuldeminas.mch.eventcrudmanager.model.Event;
import br.edu.ifsuldeminas.mch.eventcrudmanager.model.Participant;
import br.edu.ifsuldeminas.mch.eventcrudmanager.repo.EventRepository;
import br.edu.ifsuldeminas.mch.eventcrudmanager.repo.ParticipantRepository;
import jakarta.validation.Valid;

@Controller
public class ParticipantController {

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/participants")
    public String listParticipants(Model model) {
        List<Participant> participants = participantRepository.findAll();

        model.addAttribute("participants", participants);
        return "participants";
    }

    @GetMapping("/participants/form")
    public String participantForm(@ModelAttribute("participant") Participant participant, Model model) {

        List<Event> events = eventRepository.findAll();
        model.addAttribute("events", events);

        return "participant_form";
    }

    @PostMapping("/participants/register")
    public String participantNew(@Valid @ModelAttribute("participant") Participant participant,
            BindingResult erros, Model model) {

        if (erros.hasErrors()) {
            List<Event> events = eventRepository.findAll();
            model.addAttribute("events", events);

            return "participant_form";
        }

        participantRepository.save(participant);

        return "redirect:/participants";
    }

    @GetMapping("/participants/update/{id}")
    public String participantUpdate(@PathVariable("id") Integer id,
            Model model) {

        Optional<Participant> participantOpt = participantRepository.findById(id);
        Participant event = participantOpt.orElse(new Participant());

        List<Event> events = eventRepository.findAll();

        model.addAttribute("events", events);
        model.addAttribute("participant", event);

        return "participant_form";
    }

    @GetMapping("/participants/delete/{id}")
    public String participantDelete(@PathVariable("id") Integer id) {

        participantRepository.delete(new Participant(id));

        return "redirect:/participants";
    }
}
