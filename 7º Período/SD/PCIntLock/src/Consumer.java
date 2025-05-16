
public class Consumer extends Thread {

	private Cube cubo;

	public Consumer(Cube cubo) {
		this.cubo = cubo;
	}

	@Override
	public void run() {
		for (int i = 0; i < Main.amount; i++) {
			cubo.get();

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
