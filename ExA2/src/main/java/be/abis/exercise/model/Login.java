package be.abis.exercise.model;

public class Login {
	private String email;
	private String password;
	
	public Login() {
		super();
	}

	public Login(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmailAddress() {
		return email;
	}

	public void setEmailAddress(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
