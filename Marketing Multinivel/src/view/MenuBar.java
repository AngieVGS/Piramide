package view;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.Actions;
import controller.Controller;

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

		add(menuFile);
	}
}