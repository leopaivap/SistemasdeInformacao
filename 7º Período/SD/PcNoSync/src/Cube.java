
public class Cube {
	private int value;
	
	public int get() {
		System.err.printf("Consumidor consumiu %d\n", value);
		return value;
	}
	
	public void put(int v) {
		System.out.printf("Produtor produziu %d\n", v);
		this.value = v;
	}
}
