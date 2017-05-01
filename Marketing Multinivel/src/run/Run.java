package run;

import java.io.IOException;

import controller.Controller;
import models.dao.Company;
import persistence.FileManager;
import view.JDialogAddProduct;
import view.JFrameManager;
import view.JdialogAddPartner;
/**
 * 
 * @author Yuliana Boyaca, Viviana Galindo, Dayan Ramirez, sebastian Rodriguez, Daniela Torres
 *
 */
public class Run {

	public static void main(String[] args) {
		FileManager fileManager;
		try {
			fileManager = new FileManager(".\\src\\data\\multinivelSocios.csv");
			Company company = fileManager.readToTree();
			JdialogAddPartner jdialogAddPartner = new JdialogAddPartner();
			JDialogAddProduct jDialogAddProduct = new JDialogAddProduct();
			JFrameManager jFrameManager = new JFrameManager();
			Controller controller = Controller.getInstance();
			controller.setCompany(company);
			controller.setjFrameManager(jFrameManager);
			controller.setJdialogAddPartner(jdialogAddPartner);
			controller.setjDialogAddProduct(jDialogAddProduct);
			jFrameManager.setVisible(true);
//			jFrameManager.refreshTablePartner(company);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
