
public class Main {

	public static void main(String[] args) {
	
		RandomA ra1 = new RandomA(1);
		RandomA ra2 = new RandomA(2);
		
		RandomB rb1 = new RandomB(1);
		RandomB rb2 = new RandomB(2);
		
		ra1.start();
		ra2.start();
		
		rb1.start();
		rb2.start();
	}

}
