package run;

import controller.Controller;
import models.comparator.ComparatorPartner;
import models.dao.Company;
import view.JFrameManager;

public class Run {

	public static void main(String[] args) {
		Company company = new Company(new ComparatorPartner());
		JFrameManager jFrameManager = new JFrameManager();
		Controller controller = Controller.getInstance();
		controller.setCompany(company);
		controller.setjFrameManager(jFrameManager);
	}
}
