
public class Consumer extends Thread {

	private Cube cubo;

	public Consumer(Cube cubo) {
		this.cubo = cubo;
	}

	@Override
	public void run() {
		while (true) {

			System.out.println("Consumidor entrando na SC.");

			synchronized (cubo) {
				if (!cubo.getSomeToConsume()) {
					try {
						cubo.wait();
					} catch (InterruptedException ie) {

					}
				}
				cubo.get();
				cubo.notify();
			}

		}
	}
}
