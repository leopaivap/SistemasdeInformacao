public class Main {
	public static void main(String[] args) {
		Printer printer = new Printer();
		
		PrinterThread job1 = new PrinterThread(printer);
		PrinterThread job2 = new PrinterThread(printer);
		PrinterThread job3 = new PrinterThread(printer);
		PrinterThread job4 = new PrinterThread(printer);
		PrinterThread job5 = new PrinterThread(printer);
		PrinterThread job6 = new PrinterThread(printer);
		PrinterThread job7 = new PrinterThread(printer);
		PrinterThread job8 = new PrinterThread(printer);
		PrinterThread job9 = new PrinterThread(printer);
		PrinterThread job10 = new PrinterThread(printer);
		
		job1.start();
		job2.start();
		job3.start();
		job4.start();
		job5.start();
		job6.start();
		job7.start();
		job8.start();
		job9.start();
		job10.start();
	}
}
