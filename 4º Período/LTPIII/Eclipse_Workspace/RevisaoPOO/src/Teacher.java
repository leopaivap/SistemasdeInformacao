
public class Teacher extends User{
	private String siape, level, area;
	
	public Teacher(int id, String siape) {
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

	public String getSiape() {
		return siape;
	}

	@Override
	public String formatPersonalData() {
		String userData = super.formatPersonalData();
		String professorData = String.format("Siape: %s\nNível: %s\nArea: %s", siape, level, area);
		
		return userData + professorData;
	}
	
}
