package in.ashokit.beans;

public class UserService 
{

	private PwdService pwdService;
	
	/*public UserService() {
		System.out.println("UserService: 0-param constructor");
	}*/
	
	public UserService(PwdService pwdService) {
		System.out.println("UserService: 1-param constructor");
		this.pwdService = pwdService;
	}
	
	public void setPwdService(PwdService pwdService) {
		System.out.println("setPwdService() -- called..");
		this.pwdService = pwdService;
	}
	
	public void registerUser(String username, String password) {
		System.out.println("registerUser() -- called..");
		String encPwd = pwdService.encrypt(password);
		System.out.println("Username: "+username+", Password: "+encPwd);
		System.out.println("Record inserted in DB...");
	}
}
