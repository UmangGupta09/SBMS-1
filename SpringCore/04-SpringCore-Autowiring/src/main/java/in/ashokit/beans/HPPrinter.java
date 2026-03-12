package in.ashokit.beans;

public class HPPrinter implements IPrinter {

	@Override
	public void print(String message) {
		// TODO Auto-generated method stub
		System.out.println("HP Printer Printing Message : "+message);
	}
	
	public HPPrinter() {
		System.out.println("HP Printer Object Created...");
	}

}
