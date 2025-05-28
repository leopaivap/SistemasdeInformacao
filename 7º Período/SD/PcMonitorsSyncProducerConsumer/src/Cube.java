
public class Cube {
	private int value;
	private boolean someToConsume = false;

	public int get() {
		System.err.printf("Consumidor consumiu %d\n", value);
		someToConsume = false;
		return value;
	}

	public void put(int v) {
		System.out.printf("Produtor produziu %d\n", v);
		someToConsume = true;
		this.value = v;
	}

	public boolean getSomeToConsume() {
		return someToConsume;
	}
}
