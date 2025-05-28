
public class Consumer extends Thread {
	
	private Cubby cubo;
	
	public Consumer(Cubby cubo) {
		this.cubo = cubo;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < Main.amount; i++) {
			cubo.get();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {}
		}
	}
}
