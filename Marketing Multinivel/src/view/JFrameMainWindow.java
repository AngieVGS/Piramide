package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class JFrameMainWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	public JFrameMainWindow() {
		setTitle(ConstantsUI.TITLE);
		setSize(700, 700);
		setLayout(new BorderLayout());
		setExtendedState(MAXIMIZED_BOTH);
		getContentPane().setBackground(Color.WHITE);
		setIconImage(ConstantsUI.IMG_ICON.getImage());
		MenuBar menuBar = new MenuBar();
		setJMenuBar(menuBar);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JFrameMainWindow();
	}
}
