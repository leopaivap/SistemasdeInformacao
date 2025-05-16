
public class Main {

	public static void main(String[] args) {
		MegaSena mega = new MegaSena(6, 10);

		RedGame red = new RedGame(mega);
		BlackGame black = new BlackGame(mega);

		red.start();
		black.start();
	}

}
