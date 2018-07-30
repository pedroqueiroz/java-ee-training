package br.com.alura.manager;

public class Company {

	private Long id = 0l;
	private String name;

	public Company(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(long id) {
		this.id = id;
	}

}
