package view;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.text.InternationalFormatter;

public class ToolBar extends JToolBar{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ToolBar() {
		setFloatable(false);
		JLabel lbid = new JLabel("ID :");
		add(lbid);
		InternationalFormatter formato = new InternationalFormatter();
		formato.setMaximum(new Integer(100));
		formato.setMinimum(new Integer(10));
		JFormattedTextField textField = new JFormattedTextField(formato);		
		add(textField);
	}
}