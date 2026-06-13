package eager_init;

public class Program {
	public static void main(String[] args) {
		EagerInitialization eager1 = EagerInitialization.getInstance();
		EagerInitialization eager2 = EagerInitialization.getInstance();
		eager1.setName("John");
		System.out.println(eager1.getName());
		System.out.println(eager2.getName());
	}
}
