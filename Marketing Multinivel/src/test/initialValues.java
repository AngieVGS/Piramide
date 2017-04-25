package test;

import java.io.IOException;

import models.entities.Partner;
import persistence.FileManager;
import structureData.SimpleList;

public class initialValues {

	public static void main(String[] args) {
		
		
		System.out.println(Integer.MAX_VALUE);
		try {
			FileManager fileManager = new FileManager(".\\src\\data\\multinivelSocios.csv");
			SimpleList<Partner> list = fileManager.read();
			
			for (int i = 1; i < list.size(); i++) {
				System.out.println(list.get(i).toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
