
public class RedGame extends Thread {
	private MegaSena mega;

	public RedGame(MegaSena mega) {
		this.mega = mega;
	}

	@Override
	public void run() {
		for (int i = 0; i < mega.getGames(); i++) {

			// Lock
			while (Lock.lock.compareAndSet(0, 1) == false)
				System.out.print("");

			System.err.println("Red in.");
			mega.play(System.err);
			System.err.println("Red out.\n");
			System.err.flush();

			// Unlock
			Lock.lock.set(0);
		}

	}

}
