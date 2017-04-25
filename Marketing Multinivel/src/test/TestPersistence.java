package test;

import java.io.IOException;

import models.dao.Company;
import models.entities.Partner;
import persistence.FileManager;
import structureData.SimpleList;

public class TestPersistence {

	public static void main(String[] args) {
		try {
			FileManager fileManager = new FileManager(".\\src\\data\\multinivelSocios.csv");
			Company company = fileManager.readToTree();
			company.imprimir();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
