package view;

import controller.Controller;
import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;


public class CellEditorTable extends AbstractCellEditor implements TableCellEditor {

	private static final long serialVersionUID = 1L;
	Controller controller;
	
	public CellEditorTable(Controller controller) {
		this.controller = controller;
	}

	@Override
	public Object getCellEditorValue() {
		return new PanelActionsTable();
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		return (JComponent)value;
	}
}