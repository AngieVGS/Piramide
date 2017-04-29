package view;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.Actions;
import controller.Controller;

/**
 * Crea un JMenuBar para la ventana principal de adminstrador.
 * 
 * @author
 *
 */
public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = 1L;

	public MenuBar() {
		JMenu menuFile = new JMenu(ConstantsUI.SENTENCE_FILE);
		setBackground(Color.WHITE);
		menuFile.setBackground(Color.WHITE);
		JMenuItem itemAddPartner = new JMenuItem(ConstantsUI.SENTENCE_ADD_PARTNER);
		itemAddPartner.setBackground(Color.WHITE);
		itemAddPartner.addActionListener(Controller.getInstance());
		itemAddPartner.setActionCommand(Actions.SHOW_DIALOG_ADD_PARTNER.name());
		menuFile.add(itemAddPartner);

		JMenuItem itemAddProduct = new JMenuItem(ConstantsUI.SENTENCE_ADD_PRODUCT);
		itemAddProduct.setBackground(Color.WHITE);
		itemAddProduct.addActionListener(Controller.getInstance());
		itemAddProduct.setActionCommand(Actions.SHOW_DIALOG_ADD_PRODUCT.name());
		menuFile.add(itemAddProduct);
		
		JMenuItem itemLoadPersistence = new JMenuItem("Load data");
		itemLoadPersistence.setBackground(Color.WHITE);
		itemLoadPersistence.addActionListener(Controller.getInstance());
		itemLoadPersistence.setActionCommand(Actions.LOAD_PERSISTENCE.name());
		menuFile.add(itemLoadPersistence);

		add(menuFile);
	}
}