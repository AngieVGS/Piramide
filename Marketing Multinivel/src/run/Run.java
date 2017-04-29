package run;

import java.io.IOException;

import controller.Controller;
import models.comparator.ComparatorPartner;
import models.dao.Company;
import persistence.FileManager;
import view.JFrameManager;
/**
 * 
 * @author Yuliana Boyaca, Viviana Galindo, Dayan Ramirez, sebastian Rodriguez, Daniela Torres
 *
 */
public class Run {

	public static void main(String[] args) {
		Company company = new Company(new ComparatorPartner());
		
		JFrameManager jFrameManager = new JFrameManager();
		Controller controller = Controller.getInstance();
		jFrameManager.refreshTablePartner(company);
		controller.setCompany(company);
		controller.setjFrameManager(jFrameManager);
	}
}
