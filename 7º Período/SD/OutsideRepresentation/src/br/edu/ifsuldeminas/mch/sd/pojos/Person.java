package br.edu.ifsuldeminas.mch.sd.pojos;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String cpf;
	private Date birthDay;
	private Address address;

	public Person(String name, String cpf, Date birthDay, Address address) {
		this.name = name;
		this.cpf = cpf;

		this.birthDay = birthDay;
		this.address = address;
	}

	public String toString() {
		return String.format("Nome: %s\nCPF: %s\nAnivers ́ario: %s", name, cpf,
				DateFormat.getDateInstance().format(birthDay));
	}

	public Address getAddress() {
		return address;
	}
}