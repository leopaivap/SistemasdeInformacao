package br.edu.ifsuldeminas.mch.eventcrudmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsuldeminas.mch.eventcrudmanager.model.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {

}
