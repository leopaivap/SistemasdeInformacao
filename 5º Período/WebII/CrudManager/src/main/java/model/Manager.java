package model;

public class Manager {

	private int id;
	private String name, email, fone, gender;
	private Company company;

	public Manager() {
		this(0);
	}

	public Manager(int id) {
		this.id = id;
		setName("");
		setEmail("");
		setFone("");
		setGender("");
	}

	public int getId() {
		return id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String nome) {
		this.name = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}