
public class Main {
	public static void main(String[] args) {
		Cube cubo = new Cube();
		
		Producer produtor = new Producer(cubo);
		produtor.setName("Produtor");
		produtor.start();
		
		Consumer consumidor = new Consumer(cubo);
		consumidor.setName("Consumidor");
		consumidor.start();
		
		System.out.println("Fim thread 'main'.");
	}
}
