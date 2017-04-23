package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.JDialogAddProduct;
import view.JFrameManager;
import view.JdialogAddPartner;

public class Controller implements ActionListener {

	private static Controller controller;
	private JFrameManager jFrameManager;
	private JdialogAddPartner jdialogAddPartner;
	private JDialogAddProduct jDialogAddProduct;

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

	private void showDialogAddProduct() {
		jDialogAddProduct = new JDialogAddProduct();
		jDialogAddProduct.setVisible(true);
		jFrameManager.addProductToTable(null);
	}

	/**
	 * Crea y muestra el dialogo Agregar Socio
	 */
	private void showDialogAddPartner() {
		jdialogAddPartner = new JdialogAddPartner();
		jdialogAddPartner.setVisible(true);
	}

	private void addProduct() {
		jDialogAddProduct.setVisible(false);
		jDialogAddProduct.cleanFields();
	}

	/**
	 * Agrega socio a la logica y a la tabla para visualizacion.
	 */
	private void addPartner() {
		jdialogAddPartner.setVisible(false);
		jdialogAddPartner.cleanFields();
		jFrameManager.addPartnerToTable(null);
	}

	public void setjFrameManager(JFrameManager jFrameManager) {
		this.jFrameManager = jFrameManager;
	}
}
