package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.JFrameManager;
import view.JdialogAddPartner;

public class Controller implements ActionListener {

	private static Controller controller;
	private JFrameManager jFrameManager;
	private JdialogAddPartner jdialogAddPartner;

	public Controller() {
		
	}
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
			break;
		case ADD_PARTNER:
			break;
		case SHOW_DIALOG_ADD_PARTNER:
			jdialogAddPartner = new JdialogAddPartner();
			jdialogAddPartner.setVisible(true);
			break;
		}
	}

	public void setjFrameManager(JFrameManager jFrameManager) {
		this.jFrameManager = jFrameManager;
	}

	public void setJdialogAddPartner(JdialogAddPartner jdialogAddPartner) {
		this.jdialogAddPartner = jdialogAddPartner;
	}
}
