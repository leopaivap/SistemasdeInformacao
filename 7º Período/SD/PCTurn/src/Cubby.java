
public class Cubby {
	private Turn turn = Turn.PRODUCER;
	private int value;
	
	public int get() {
		while (turn != Turn.CONSUMER) { 
			System.out.print("");
		}
		
		System.err.printf("Consumidor consumiu %d\n", value);
		
		int oldValue = value;
		turn = Turn.PRODUCER;
		
		return oldValue;
	}
	
	public void put(int v) {
		while (turn != Turn.PRODUCER) { 
			System.out.print("");
		}
		
		System.out.printf("Produtor produziu %d\n", v);
		this.value = v;
		
		turn = Turn.CONSUMER;
	}
}
