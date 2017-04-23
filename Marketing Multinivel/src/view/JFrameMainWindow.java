package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JFrameMainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private Object[] columnsPartners;
	private Object[] columnsProducts;
	private Object[] columnsOrders;

	public JFrameMainWindow() {
		setTitle(ConstantsUI.TITLE);
		setSize(700, 700);
		setLayout(new BorderLayout());
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setIconImage(ConstantsUI.IMG_ICON.getImage());
		MenuBar menuBar = new MenuBar();
		setJMenuBar(menuBar);

		columnsPartners = new Object[] { ConstantsUI.SENTENCE_ID_PARTNER, ConstantsUI.SENTENCE_REGISTER,
				ConstantsUI.SENTENCE_FIRST_NAME, ConstantsUI.SENTENCE_LAST_NAME, ConstantsUI.SENTENCE_GENRE,
				ConstantsUI.SENTENCE_NACIMIENTO, ConstantsUI.SENTENCE_STATUS, ConstantsUI.SENTENCE_PARENT,
				ConstantsUI.SENTENCE_PARENT };
		columnsProducts = new Object[] { ConstantsUI.SENTENCE_ID_PRODUCT, ConstantsUI.SENTENCE_LINEA,
				ConstantsUI.SENTENCE_REFERENCE, ConstantsUI.SENTENCE_TARGET, ConstantsUI.SENTENCE_VALUE };
		columnsOrders = new Object[] { ConstantsUI.SENTENCE_ID_ORDER, ConstantsUI.SENTENCE_DATE,
				ConstantsUI.SENTENCE_ID_PARTNER, ConstantsUI.SENTENCE_QUANTITY, ConstantsUI.SENTENCE_STATE };
		
		JPanel pnCentralStudents = new JPanel();
		pnCentralStudents.setBackground(ConstantsUI.COLOR_FOUND);
		GridSystem gridSystem = new GridSystem(pnCentralStudents);
		
		DefaultTableModel partnersModel = new DefaultTableModel();
		partnersModel.setColumnIdentifiers(columnsPartners);
		JTable tbParner = new JTable(partnersModel);
		
		tbParner.getTableHeader().setBackground(ConstantsUI.COLOR_TABLE_MANAGER);
		tbParner.getTableHeader().setFont(ConstantsUI.FONT_LETTER_TABLE);
		tbParner.getTableHeader().setForeground(Color.WHITE);
		tbParner.setRowHeight(30);
		tbParner.setSelectionBackground(Color.decode("#2b82ad"));
		tbParner.setSelectionForeground(Color.WHITE);
		
		JScrollPane panelStudents = new JScrollPane(tbParner);
		panelStudents.setBackground(Color.WHITE);
		pnCentralStudents.add(panelStudents, gridSystem.insertComponent(1, 1, 10, 0.15));
//		pnTabStudents.add(pnCentralStudents, BorderLayout.CENTER);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new JFrameMainWindow();
	}
}
