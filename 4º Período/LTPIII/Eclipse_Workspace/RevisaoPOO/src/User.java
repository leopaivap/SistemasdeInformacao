public abstract class User {
	private int id;
	private String name, birthDate;
	
	protected User(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	public String formatPersonalData() {
	//	return "ID: " + this.id + " Nome: " + this.name;
		return String.format("ID: %d \nNome: %s\n", this.id, this.name);
	}

}
