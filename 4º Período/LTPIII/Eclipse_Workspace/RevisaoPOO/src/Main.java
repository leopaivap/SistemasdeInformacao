public class Main {

	public static void main(String[] args) {
		Student maria = new Student(1, 999);
		maria.setName("Maria");
		maria.setBirthDate("11/06/2000");
		maria.setCourse("SI");
		maria.setSemester((short)4);
		
		Student jose = new Student(2, 888);
		jose.setName("José");
		jose.setBirthDate("06/08/2001");
		jose.setCourse("ADM");
		jose.setSemester((short)8);
		
		Teacher emerson = new Teacher(2, "217");
		emerson.setName("Emerson");
		emerson.setLevel("Doutor");
		emerson.setArea("Informática");
		
		AT ju = new AT(3, "891");
		ju.setName("Julia");
		ju.setArea("TI");
		ju.setRole("Técnica em Laboratório");
		
		printUserData(maria);
		printUserData(emerson);
		printUserData(ju);

	}
	
	private static void printUserData(User user) {
		System.out.println(user.formatPersonalData());
	}

}
