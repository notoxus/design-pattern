package eager_init;

public class LazyInitialization {
	private static LazyInitialization LAZYINSTANCE;
	private LazyInitialization() {}
	public LazyInitialization getInstance() {
		if(LAZYINSTANCE == null) LAZYINSTANCE = new LazyInitialization();
		return LAZYINSTANCE;
	}
}
