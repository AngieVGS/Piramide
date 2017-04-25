package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import models.entities.Order;
import models.entities.Partner;
import models.entities.Product;

/**
 * Ventana principal de administrador.
 * 
 * @author
 */
public class JFrameManager extends JFrame {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel partnersModel;
	private JTable tbParner;
	private DefaultTableModel productsModel;
	private JTable tbProducts;
	private DefaultTableModel ordersModel;
	private JTable tbOrders;
	private JTabbedPane tabs;

	/**
	 * Constructor de ventana principal del Administrador
	 */
	public JFrameManager() {
		setTitle(ConstantsUI.TITLE);
		setSize(700, 700);
		setExtendedState(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setIconImage(ConstantsUI.IMG_ICON.getImage());
		MenuBar menuBar = new MenuBar();
		setJMenuBar(menuBar);

		Object[] columnsPartners = new Object[] { ConstantsUI.SENTENCE_ID_PARTNER, ConstantsUI.SENTENCE_REGISTER,
				ConstantsUI.SENTENCE_ID_LEGAL, ConstantsUI.SENTENCE_FIRST_NAME, ConstantsUI.SENTENCE_LAST_NAME,
				ConstantsUI.SENTENCE_GENRE, ConstantsUI.SENTENCE_NACIMIENTO, ConstantsUI.SENTENCE_STATUS,
				ConstantsUI.SENTENCE_PARENT };
		Object[] columnsProducts = new Object[] { ConstantsUI.SENTENCE_ID_PRODUCT, ConstantsUI.SENTENCE_LINEA,
				ConstantsUI.SENTENCE_REFERENCE, ConstantsUI.SENTENCE_TARGET, ConstantsUI.SENTENCE_VALUE };
		Object[] columnsOrders = new Object[] { ConstantsUI.SENTENCE_ID_ORDER, ConstantsUI.SENTENCE_DATE,
				ConstantsUI.SENTENCE_ID_PARTNER, ConstantsUI.SENTENCE_QUANTITY, ConstantsUI.SENTENCE_STATE };

		JPanel pnCentralPartner = new JPanel();
		pnCentralPartner.setBackground(ConstantsUI.COLOR_FOUND);
		GridSystem gridSystem = new GridSystem(pnCentralPartner);

		partnersModel = new DefaultTableModel();
		partnersModel.setColumnIdentifiers(columnsPartners);
		tbParner = new JTable(partnersModel);

		tbParner.getTableHeader().setBackground(ConstantsUI.COLOR_TABLE_MANAGER);
		tbParner.getTableHeader().setFont(ConstantsUI.FONT_LETTER_TABLE);
		tbParner.getTableHeader().setForeground(Color.WHITE);
		tbParner.setRowHeight(30);
		tbParner.setSelectionBackground(ConstantsUI.COLOR_SELECTION_BACKGROUND);
		tbParner.setSelectionForeground(Color.WHITE);

		JScrollPane pnPartner = new JScrollPane(tbParner);
		pnPartner.setBackground(Color.WHITE);
		pnCentralPartner.add(pnPartner, gridSystem.insertComponent(1, 1, 10, 0.15));

		productsModel = new DefaultTableModel();
		productsModel.setColumnIdentifiers(columnsProducts);
		tbProducts = new JTable(productsModel);

		tbProducts.getTableHeader().setBackground(ConstantsUI.COLOR_TABLE_MANAGER);
		tbProducts.getTableHeader().setFont(ConstantsUI.FONT_LETTER_TABLE);
		tbProducts.getTableHeader().setForeground(Color.WHITE);
		tbProducts.setRowHeight(30);
		tbProducts.setSelectionBackground(ConstantsUI.COLOR_SELECTION_BACKGROUND);
		tbProducts.setSelectionForeground(Color.WHITE);

		JScrollPane pnProducts = new JScrollPane(tbProducts);
		pnProducts.setBackground(Color.WHITE);
		pnCentralPartner.add(pnProducts, gridSystem.insertComponent(1, 1, 10, 0.15));

		ordersModel = new DefaultTableModel();
		ordersModel.setColumnIdentifiers(columnsOrders);
		tbOrders = new JTable(ordersModel);

		tbOrders.getTableHeader().setBackground(ConstantsUI.COLOR_TABLE_MANAGER);
		tbOrders.getTableHeader().setFont(ConstantsUI.FONT_LETTER_TABLE);
		tbOrders.getTableHeader().setForeground(Color.WHITE);
		tbOrders.setRowHeight(30);
		tbOrders.setSelectionBackground(ConstantsUI.COLOR_SELECTION_BACKGROUND);
		tbOrders.setSelectionForeground(Color.WHITE);

		JScrollPane pnOrders = new JScrollPane(tbOrders);
		pnOrders.setBackground(Color.WHITE);
		pnCentralPartner.add(pnOrders, gridSystem.insertComponent(1, 1, 10, 0.15));

		tabs = new JTabbedPane();
		tabs.addTab(ConstantsUI.SENTENCE_PARTNER, ConstantsUI.IMG_TAB_PARTNER, pnPartner);
		tabs.addTab(ConstantsUI.SENTENCE_PRODUCT, ConstantsUI.IMG_TAB_PRODUCT, pnProducts);
		tabs.addTab(ConstantsUI.SENTENCE_ORDERS, ConstantsUI.IMG_TAB_ORDER, pnOrders);
		pnCentralPartner.add(tabs, gridSystem.insertComponent(1, 1, 10, 1));
		add(pnCentralPartner, BorderLayout.CENTER);
		setVisible(true);
	}

	/**
	 * Agrega Socio especificado a la tabla y refresca.
	 * 
	 * @param partner
	 */
	public void addPartnerToTable(Partner partner) {
		partnersModel.addRow(partner.getPartner());
		tabs.setSelectedIndex(0);
	}

	/**
	 * Agrega el producto especificado a la tabla y refresca.
	 * 
	 * @param product
	 */
	public void addProductToTable(Product product) {
		productsModel.addRow(product.getProduct());
		tabs.setSelectedIndex(1);
		// TODO: refrescar tabla.
	}

	/**
	 * Agrega la orden especificado a la tabla y refresca.
	 * 
	 * @param order
	 */
	public void addOrderToTable(Order order) {
		// ordersModel.addRow(order.getTable());
		tabs.setSelectedIndex(2);
		// TODO: Terminar.
	}
}
