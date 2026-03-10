package in.ashokit.beans;

public class PwdService {

	public PwdService() {
		System.out.println("PwdService: 0-param constructor");
	}
	
	public String encrypt(String pwd) {
		return "Encrypted-"+pwd;
	}
}
