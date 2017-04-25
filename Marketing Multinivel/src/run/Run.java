package run;

import controller.Controller;
import models.comparator.ComparatorPartner;
import models.dao.Company;
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
		controller.setCompany(company);
		controller.setjFrameManager(jFrameManager);
	}
}
