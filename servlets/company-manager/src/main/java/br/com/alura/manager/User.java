package br.com.alura.manager;

public class User {

	private String email;
	private String password;

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

}
