
public class Producer extends Thread {

	private Cube cubo;

	public Producer(Cube cubo) {
		this.cubo = cubo;
	}

	@Override
	public void run() {
		while (true) {
			cubo.put((int) (Math.random() * 100));
		}
	}
}
