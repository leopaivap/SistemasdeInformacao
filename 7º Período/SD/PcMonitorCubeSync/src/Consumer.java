
public class Consumer extends Thread {

	private Cube cubo;

	public Consumer(Cube cubo) {
		this.cubo = cubo;
	}

	@Override
	public void run() {
		while (true) {
			cubo.get();
		}
	}
}
