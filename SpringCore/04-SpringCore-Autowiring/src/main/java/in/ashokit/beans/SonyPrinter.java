package in.ashokit.beans;

public class SonyPrinter implements IPrinter {

	@Override
	public void print(String message) {
		// TODO Auto-generated method stub
 		System.out.println("Sony Printer Printing Message : "+message);
	}
	
	public SonyPrinter() {
		System.out.println("Sony Printer Object Created...");
	}

}
