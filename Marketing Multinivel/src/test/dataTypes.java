package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import models.entities.Genre;
import models.entities.Partner;
import persistence.ManagerPartners;
import persistence.PartnerInFile;

public class dataTypes {

	public static void main(String[] args) {
//		Partner  partener = new Partner(8, new Date(2001, 3, 8), 8, "Juan", "Alvarez", Genre.MALE, new Date(1996, 7, 8), 2, 7);
//		
//		PartnerInFile partnerInFile = new PartnerInFile(8, new Date(2001, 3, 8), 8, "Juan", "Alvarez", Genre.MALE, new Date(1996, 7, 8), 2, 7);
//		ManagerPartners managerPartners = new ManagerPartners(".\\src\\data\\part.dat");
//		try {
//			managerPartners.open();
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		try {
//			managerPartners.write(partnerInFile);
//			managerPartners.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		ManagerPartners managerPartners = new  ManagerPartners(".\\src\\data\\part.dat");
		try {
			managerPartners.openToRead();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(managerPartners.readFromFile().toString());
		
		try {
			managerPartners.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
