package in.ashokit.beans;

public class Car {

	private IEngine engine;

	public Car() {
		super();
		System.out.println("Car Object Created Default Contructor...");
	}
	public Car(IEngine engine) {
		super();
		System.out.println("Car Object Created...");
		this.engine = engine;
	}
	
	public void setEngine(IEngine engine) {
		this.engine = engine;
	}

	public void startCar() {
		engine.start();
	}
}
