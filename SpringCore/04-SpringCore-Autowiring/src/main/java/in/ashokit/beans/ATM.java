package in.ashokit.beans;

public class ATM {
	
	private IPrinter printer;

	public ATM() {
		super();
		System.out.println("ATM Object Created Default Constructor...");
	}

	public ATM(IPrinter printer) {
		super();
		System.out.println("ATM Object Created paramterized...");
		this.printer = printer;
	}

	public void setPrinter(IPrinter printer) {
		System.out.println("ATM setPrinter() method called...");
		this.printer = printer;
	}
	
	public void print(String message) {
		printer.print(message);
	}

}
