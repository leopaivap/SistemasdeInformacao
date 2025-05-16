import java.io.PrintStream;
import java.util.Random;

public class MegaSena {
	private int numbersPerGame;
	private int games;

	public static final int MAX_VALUE = 60;

	public MegaSena(int numbersPerGame, int games) {
		this.numbersPerGame = numbersPerGame;
		this.games = games;
	}

	public int getGames() {
		return games;
	}

	public void play(PrintStream printer) {
		for (int i = 0; i < numbersPerGame; i++) {
			int number = new Random().nextInt(MAX_VALUE) + 1;
			printer.print(String.format("%2d ", number));
		}
		printer.println();
	}

}
