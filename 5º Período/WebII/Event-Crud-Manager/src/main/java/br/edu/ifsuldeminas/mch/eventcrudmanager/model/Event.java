package br.edu.ifsuldeminas.mch.eventcrudmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "events")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotBlank(message = "O nome não pode ser vazio!")
	private String name;

	@NotBlank(message = "O local não pode ser vazio!")
	private String place;

	@NotBlank(message = "A data não pode ser vazia!")
	private String date;

	@NotNull(message = "A capacidade não pode ser vazia!")
	@Digits(fraction = 0, integer = 10, message = "Número inválido.")
	private Integer capacity;

	public Event() {

	}

	public Event(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id){
	this.id = id;
	}

}
