package br.edu.ifsuldeminas.mch.sd.pojos;

import java.io.Serializable;

public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	private String patio;
	private int number;
	private String neighborhood;
	private String zipCode;
	private String city;

	private String state;

	public Address(String patio, int number, String neighborhood, String zipCode, String city, String state) {
		this.patio = patio;
		this.number = number;
		this.neighborhood = neighborhood;
		this.zipCode = zipCode;
		this.city = city;
		this.state = state;
	}

	public String toString() {
		return String.format("Enderec ̧o: %s, %d, %s, %s, %s - %s", patio, number, neighborhood, zipCode, city, state);
	}
}