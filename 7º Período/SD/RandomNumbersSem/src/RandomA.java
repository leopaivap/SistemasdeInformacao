import java.util.Random;

public class RandomA extends Thread {

	public String id;

	public RandomA(int id) {
		this.id = "A-".concat(String.valueOf(id));
	}

	@Override
	public void run() {
		while (true) {
			try {
				// Operação P(s) - decremento
				Lock.lock.acquire();

				int number = new Random().nextInt(100);
				System.out.printf("Random-%s\n", id);
				System.out.printf("%s-> %d\n", id, number);

				Thread.sleep(number);
			} catch (InterruptedException ie) {

			} finally {
				// Operação V(s) -
				Lock.lock.release();
			}

		}
	}
}
