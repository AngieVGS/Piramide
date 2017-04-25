package view;

import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableRender extends DefaultTableCellRenderer {

	private static final long serialVersionUID = 1L;
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		if(value instanceof JComponent) {
			JComponent component = (JComponent) value;
    		return component;
    	}
    	return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	}
}