package view;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = 1L;
	
	public MenuBar() {
		JMenu menuFile = new JMenu();
		setBackground(Color.WHITE);
		menuFile.setBackground(Color.WHITE);
				add(menuFile);
		add(menuFile);
	}
}