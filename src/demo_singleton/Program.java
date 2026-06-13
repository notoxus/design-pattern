package demo_singleton;

public class Program {
	public static void main(String[] args) {
		Thread thread1 = new Thread(() -> EarthSingleton.getInstance().hello());
		Thread thread2 = new Thread(() -> EarthSingleton.getInstance().hello());
		
		thread1.start();
		thread2.start();
	}
}
