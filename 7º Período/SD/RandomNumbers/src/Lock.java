import java.util.concurrent.locks.ReentrantLock;

public class Lock {
	public final static ReentrantLock lock = new ReentrantLock(true);
}
