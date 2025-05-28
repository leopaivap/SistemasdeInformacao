import java.util.concurrent.Semaphore;

public class Lock {
	public final static Semaphore lock = new Semaphore(1);
}
