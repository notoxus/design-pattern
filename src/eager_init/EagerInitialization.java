package eager_init;

public class EagerInitialization {
	private static final EagerInitialization EAGERINSTANCE = new EagerInitialization();
	private EagerInitialization() {}
	public static EagerInitialization getInstance() {
		return EAGERINSTANCE;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
