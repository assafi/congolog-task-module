package toybox;

public class CarToy {

	private int speed = 0;
	
	public void beep() {
		System.out.println("Beep Beep");
	}
	
	public void accelerate() {
		System.out.println("Vroooom");
		speed += 5;
	}
	
	public void startEnging() {
		System.out.println("Mmmmm Mmmmm");
	}
}
