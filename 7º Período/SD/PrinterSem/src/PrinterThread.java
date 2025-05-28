import java.io.PrintStream;
import java.util.Random;

public class PrinterThread extends Thread {

	private static final int MAX_MESSAGE = 10;
	private Printer printer;
	private PrintStream stream;
	
	public void setStream(PrintStream stream) {
		this.stream = stream;
	}
	
	public PrinterThread(Printer print) {
		this.printer = print;
	}
	
	public PrintStream getStream() {
		return stream;
	}
	
	@Override
	public void run() {
		while(true) {
			int amount = new Random().nextInt(MAX_MESSAGE);
			String[] numbers = new String[amount+1];
			numbers[0] = String.format("%s-> Total: %d\n", 
					Thread.currentThread().getName(), amount);
			
			for (int i = 1; i < numbers.length; i++) {
				numbers[i] = String.format("%s: %d\n", 
						Thread.currentThread().getName(), i);
			}
			
			printer.printMessages(numbers, this);
		}
	}
}
