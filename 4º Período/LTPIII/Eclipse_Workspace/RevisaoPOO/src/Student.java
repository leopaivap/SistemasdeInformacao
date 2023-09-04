public class Student extends User{

	private int enrolment;
	private String course;
	private short semester;
	
	public Student(int idUser, int enrolment) {
		super(idUser);
		this.enrolment = enrolment;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public short getSemester() {
		return semester;
	}

	public void setSemester(short semester) {
		this.semester = semester;
	}

	public int getEnrolment() {
		return enrolment;
	}
	
	@Override
	public String formatPersonalData() {
		String userData = super.formatPersonalData();
		String studentData = String.format("RA: %s\nCurso: %s\nP: %d", this.enrolment, this.course, this.semester);
		return userData + studentData;
	}
	
}
