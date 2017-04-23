package run;

import controller.Controller;
import view.JFrameManager;

public class Run {

	public static void main(String[] args) {
		JFrameManager jFrameManager = new JFrameManager();
		Controller controller = Controller.getInstance();
		controller.setjFrameManager(jFrameManager);
	}
}
