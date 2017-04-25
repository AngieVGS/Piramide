package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exceptions.RegisteredPartner;
import models.dao.Company;
import models.entities.Partner;
import models.entities.Product;
import view.JDialogAddProduct;
import view.JFrameManager;
import view.JdialogAddPartner;

/**
 * 
 * @author Yuliana Boyaca, Viviana Galindo, Dayan Ramirez, sebastian Rodriguez,
 *         Daniela Torres
 *
 */
public class Controller implements ActionListener {

	private static Controller controller;
	private JFrameManager jFrameManager;
	private JdialogAddPartner jdialogAddPartner;
	private JDialogAddProduct jDialogAddProduct;
	private Company company;

	public static Controller getInstance() {
		if (controller == null) {
			controller = new Controller();
		}
		return controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Actions.valueOf(e.getActionCommand())) {
		case ADD_ORDER:
			break;
		case ADD_PRODUCT:
			addProduct();
			break;
		case ADD_PARTNER:
			addPartner();
			break;
		case SHOW_DIALOG_ADD_PARTNER:
			showDialogAddPartner();
			break;
		case SHOW_DIALOG_ADD_PRODUCT:
			showDialogAddProduct();
			break;
		}
	}

	/**
	 * Muestra el dialogo Agregaar Producto
	 */
	private void showDialogAddProduct() {
		jDialogAddProduct = new JDialogAddProduct();
		jDialogAddProduct.setVisible(true);
	}

	/**
	 * Crea y muestra el dialogo Agregar Socio
	 */
	private void showDialogAddPartner() {
		jdialogAddPartner = new JdialogAddPartner();
		jdialogAddPartner.setVisible(true);
	}

	/**
	 * Agrega producto a la tabla.
	 */
	private void addProduct() {
		jDialogAddProduct.setVisible(false);
		Product product = jDialogAddProduct.getProductToDialog();
		jFrameManager.addProductToTable(product);
		jDialogAddProduct.cleanFields();
	}

	/**
	 * Agrega socio a la logica y a la tabla para visualizacion.
	 */
	private void addPartner() {
		Partner partner = jdialogAddPartner.getCreatedPartner();
		if (company.searchPartner(partner.getParent()) != null || partner.getParent() == 0) {
			try {
				company.registerPartner(partner);
				jdialogAddPartner.setVisible(false);
				jFrameManager.addPartnerToTable(partner);
				jdialogAddPartner.cleanFields();
			} catch (RegisteredPartner e) {
			}
		} else {
			JdialogAddPartner.showErrorPartner();
			Partner.setIdConsecutive(Partner.getIdConsecutive() - 1);
		}
	}

	public void setjFrameManager(JFrameManager jFrameManager) {
		this.jFrameManager = jFrameManager;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
