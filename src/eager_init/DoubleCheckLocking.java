package eager_init;

public class DoubleCheckLocking {
	private static volatile DoubleCheckLocking INSTANCE;
	private DoubleCheckLocking() {}
	public static DoubleCheckLocking getInstance() {
		if(INSTANCE == null) 
			synchronized(DoubleCheckLocking.class) {
				if(INSTANCE == null) INSTANCE = new DoubleCheckLocking();
			}
		return INSTANCE;
	}
}
