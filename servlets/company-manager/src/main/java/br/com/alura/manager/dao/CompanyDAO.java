package br.com.alura.manager.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.alura.manager.Company;

public class CompanyDAO {

	private final static Map<Long, Company> COMPANIES = new HashMap<>();
	static {
		generateIdAndAdd(new Company("Doceria Bela Vista"));
		generateIdAndAdd(new Company("Ferragens Docel"));
		generateIdAndAdd(new Company("Alura"));
		generateIdAndAdd(new Company("Google"));
		generateIdAndAdd(new Company("Caelum"));
		generateIdAndAdd(new Company("Casa do Código"));
	}

	public Collection<Company> searchBySimilarity(String name) {
		if (name == null)
			return COMPANIES.values();
		
		List<Company> similar = new ArrayList<>();
		for (Company company : COMPANIES.values()) {
			if (company.getName().toLowerCase().contains(name.toLowerCase()))
				similar.add(company);
		}
		return similar;
	}

	public void add(Company company) {
		generateIdAndAdd(company);
	}

	private static void generateIdAndAdd(Company company) {
		long id = COMPANIES.size()+1l;
		company.setId(id);
		COMPANIES.put(id, company);
	}
}
