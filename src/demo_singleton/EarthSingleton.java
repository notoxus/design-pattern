package demo_singleton;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Random;

public class EarthSingleton {
	/*
	 * Cach 1: private static EarthSingleton uniqueInstance = new EarthSingleton();
	 * private EarthSingleton() { } public static EarthSingleton getInstance() {
	 * return uniqueInstance; } public void hello() {
	 * System.out.println("Hello world!"); }
	 */
	/*
	 * private static EarthSingleton uniqueInstance; private EarthSingleton() { }
	 * public static EarthSingleton getInstance() { if(uniqueInstance == null)
	 * uniqueInstance = new EarthSingleton(); return uniqueInstance; } public void
	 * hello() { System.out.println("Hello world!"); }
	 */
	
	/*
	 * Truong hop multi thread, boi vi co den 2 thuc the trai dat:)))
	 * That ra no van dung neu la multiverse hahah
	private int index;
	private static EarthSingleton uniqueInstance;

	private EarthSingleton(int index) {
		this.index = index;
	}

	public static EarthSingleton getInstance() {
		if (uniqueInstance == null) {
			Random random = new Random();
			uniqueInstance = new EarthSingleton(random.nextInt(1,5));
		}
		return uniqueInstance;
	}

	public void hello() {
		System.out.println("Hello world " + index);
	}
	*/
	// Dung bien static voi tu khoa volatile và synchronized de ngan khong cho nhan thread2
	private int index;
	private volatile static EarthSingleton uniqueInstance;
	private EarthSingleton(int index) {
		this.index = index;
	}

	public static EarthSingleton getInstance() {
		if (uniqueInstance == null) {
			synchronized (EarthSingleton.class) {
				Random random = new Random();
			uniqueInstance = new EarthSingleton(random.nextInt(1,5));
			}
		}
		return uniqueInstance;
	}

	public void hello() {
		System.out.println("Hello world " + index);
	}
}
