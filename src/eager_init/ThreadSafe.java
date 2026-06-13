package eager_init;

public class ThreadSafe {
	private static volatile ThreadSafe INSTANCE;
	private ThreadSafe() {}
	public static synchronized ThreadSafe getInstance() {
		if(INSTANCE == null) INSTANCE = new ThreadSafe();
		return INSTANCE;
	}
}
