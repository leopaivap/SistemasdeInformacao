package br.edu.ifsuldeminas.mch.eventcrudmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.ifsuldeminas.mch.eventcrudmanager.model.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
	@Query("SELECT COUNT(p) > 0 FROM Participant p WHERE p.event.id = :eventId")
	boolean existsByEventId(@Param("eventId") Integer eventId);

}
