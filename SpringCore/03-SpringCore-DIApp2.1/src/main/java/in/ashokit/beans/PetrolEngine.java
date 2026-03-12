package in.ashokit.beans;

public class PetrolEngine implements IEngine {

	@Override
	public void start() {
		// TODO Auto-generated method stub
        System.out.println("Petrol Engine Started...");
	}
	
	public PetrolEngine() {
		System.out.println("Petrol Engine Object Created...");
	}

}
