package test;

import models.entities.Company;

public class TestCompany {

	public static void main(String[] args) {
//		Company company = new Company();
		System.out.println(Company.createPartner(12, "Hola", null).toString());
	}
}
