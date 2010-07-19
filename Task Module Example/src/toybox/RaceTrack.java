package toybox;

public class RaceTrack {

	public static void main(String[] args) {
		CarToy car = new CarToy();
		
		// Task #1 - Must start the engine before accelerating 
		// Task #2 - Beep when car.speed > 0
		
		// Task #1 - Success
		// Task #2 - Success
		car.startEngine();
		car.accelerate();
		car.beep();
		
		CarToy car2 = new CarToy();
		// Task #1 - Fail
		// Task #2 - Success
		car2.accelerate();
		car2.startEngine();
		car2.beep();
	}
}
