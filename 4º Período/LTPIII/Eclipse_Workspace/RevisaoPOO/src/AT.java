public class AT extends User {
	private String siape, level, area, role;
	
	public AT(int id, String siape) {
		super(id);
		this.siape = siape;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSiape() {
		return siape;
	}
	
	@Override
	public String formatPersonalData() {
		String userData = super.formatPersonalData();
		String taData = String.format("Siape: %s\nNível: %s\nFunçao: %s", siape, level, role);
		
		return userData + taData;
	}
}
