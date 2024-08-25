package br.edu.ifsuldeminas.mch.eventcrudmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsuldeminas.mch.eventcrudmanager.model.Event;
import br.edu.ifsuldeminas.mch.eventcrudmanager.model.Participant;
import br.edu.ifsuldeminas.mch.eventcrudmanager.repo.EventRepository;
import br.edu.ifsuldeminas.mch.eventcrudmanager.repo.ParticipantRepository;
import jakarta.transaction.Transactional;

@Component
@Transactional
public class InitializeDataBase implements CommandLineRunner {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    @Override
    public void run(String... args) throws Exception {

        Event aws = new Event();
        aws.setName("AWS Summit");
        aws.setPlace("São Paulo, Brasil");
        aws.setDate("12/10/2024");
        aws.setCapacity(2000);

        Event evento2 = new Event();
        evento2.setName("Outro Evento");
        evento2.setPlace("Belo Horizonte, Brasil");
        evento2.setDate("11/01/2025");
        evento2.setCapacity(575);

        eventRepository.save(aws);
        eventRepository.save(evento2);
        eventRepository.flush();

        Participant leonardo = new Participant();
        leonardo.setName("Leonardo P");
        leonardo.setEmail("leonardo@mail.com");
        leonardo.setTicketType("VIP");
        leonardo.setEvent(aws);

        Participant mariana = new Participant();
        mariana.setName("Mariana P");
        mariana.setEmail("mariana@mail.com");
        mariana.setTicketType("Normal");
        mariana.setEvent(evento2);

        participantRepository.save(leonardo);
        participantRepository.save(mariana);

    }

}
