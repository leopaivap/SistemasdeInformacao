
public class Consumer extends Thread {
	
	private Cube cubo;
	
	public Consumer(Cube cubo) {
		this.cubo = cubo;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			cubo.get();
		}
	}
}
