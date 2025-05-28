
public class Main {
	
	public static int amount = 100;
	
	public static void main(String[] args) {
		Cubby cubo = new Cubby();
		
		Producer produtor = new Producer(cubo);
		produtor.setName("Produtor");
		produtor.start();
		
		Consumer consumidor = new Consumer(cubo);
		consumidor.setName("Consumidor");
		consumidor.start();
		
		System.out.println("Fim thread 'main'.");
	}
}
