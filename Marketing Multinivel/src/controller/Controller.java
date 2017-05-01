package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import exceptions.RegisteredPartner;
import models.dao.Company;
import models.entities.Partner;
import models.entities.Product;
import persistence.FileManager;
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
		case EDIT_PARTNER:
			editPartner();
			break;
		case SHOW_DIALOG_EDIT_PARTNER:
			showDialogEditPartner();
			break;
		case SHOW_ORDERS:
			showOrders();
			break;
		case LOAD_PERSISTENCE:
			loadPersistence();
			break;
		}
	}

	/**
	 * carga los datos de la persistencia
	 */
	private void loadPersistence() {
		try {
			FileManager fileManager = new FileManager(".\\src\\data\\multinivelSocios.csv");
			company = fileManager.readToTree();
		} catch (IOException e) {
			e.printStackTrace();
		}
		jFrameManager.refreshTablePartner(company);
	}

	/**
	 * muestra las ordenes del socio seleccionado
	 */
	private void showOrders() {
//		JDialogShowOrdersPartner  n  =  new JDialogShowOrdersPartner();
//		n.addOrderToTable(company.getOrdersOfAPartner(company.searchPartner(jFrameManager.getIdPartnerSelected())));
	}

	/**
	 * Edita socio
	 */
	private void editPartner() {
		try {
			company.editPartner(jFrameManager.getIdPartnerSelected(), jdialogAddPartner.getCreatedPartner());
			jFrameManager.refreshTablePartner(company);
			jdialogAddPartner.cleanFields();
			jdialogAddPartner.setVisible(false);
		} catch (Exception e) {
		}
	}

	/**
	 * muestra dialogo Editar socio
	 */
	private void showDialogEditPartner() {
		jdialogAddPartner.changeEdit(
				company.searchPartner
				(jFrameManager.getIdPartnerSelected()));
		jdialogAddPartner.setVisible(true);
	}

	/**
	 * Muestra el dialogo Agregaar Producto
	 */
	private void showDialogAddProduct() {
		jDialogAddProduct.setVisible(true);
	}

	/**
	 * Crea y muestra el dialogo Agregar Socio
	 */
	private void showDialogAddPartner() {
		jdialogAddPartner.changeAdd();
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
		if (partner.getParent() == 0 || company.searchPartner(partner.getParent()) != null) {
			try {
				company.registerPartner(partner);
				jdialogAddPartner.setVisible(false);
				jFrameManager.refreshTablePartner(company);
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

	public void setJdialogAddPartner(JdialogAddPartner jdialogAddPartner) {
		this.jdialogAddPartner = jdialogAddPartner;
	}

	public void setjDialogAddProduct(JDialogAddProduct jDialogAddProduct) {
		this.jDialogAddProduct = jDialogAddProduct;
	}	
}