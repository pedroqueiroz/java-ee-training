package br.com.alura.manager.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.alura.manager.User;

public class UserDAO {

	private final static Map<String, User> USERS = new HashMap<>();
	static {
		USERS.put("guilherme.silveira@alura.com.br", new User("guilherme.silveira@alura.com.br","silveira"));
		USERS.put("test@alura.com.br", new User("test@alura.com.br","test"));
	}

	public User searchByEmailAndPassword(String email, String password) {
		if (!USERS.containsKey(email))
			return null;

		User user = USERS.get(email);
		if (user.getPassword().equals(password))
			return user;
		
		return null;
	}

}
