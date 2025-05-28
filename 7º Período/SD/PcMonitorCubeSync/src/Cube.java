
public class Cube {
	private int value;
	private boolean someToConsume = false;

	public synchronized int get() {
		if (!someToConsume) {
			try {
				this.wait();
			} catch (InterruptedException ie) {

			}
		}

		System.err.printf("Consumidor consumiu %d\n", value);
		someToConsume = false;

		this.notify();
		return value;
	}

	public synchronized void put(int v) {
		if (someToConsume) {
			try {
				this.wait();
			} catch (InterruptedException ie) {

			}
		}

		System.out.printf("Produtor produziu %d\n", v);
		someToConsume = true;

		this.notify();
		this.value = v;
	}
}
