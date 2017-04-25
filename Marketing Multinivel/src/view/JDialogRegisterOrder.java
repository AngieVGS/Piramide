package view;


import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import controller.Actions;
import controller.Controller;
import exceptions.ValidateFields;
import models.entities.Genre;
import models.entities.Order;
import models.entities.Partner;

public class JDialogRegisterOrder extends JDialog{
	private static final long serialVersionUID = 1L;
	private JTextField txtCodeProduct, txtIdParnet, txtQuantity, txtIdRegister;
	private JSpinner spinerStratum;
	private JButton btnAdd;
	private JDateChooser date;

	public  JDialogRegisterOrder() {
		setSize(450, 450);
		setModal(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("/img/order.png")).getImage());
		setTitle("New Order");
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLayout(new GridBagLayout());
		getContentPane().setBackground(Color.WHITE);
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.insets.set(0, 2, 2, 40);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0.5;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel lbCodeProduct = new JLabel("Code Product: ");
		lbCodeProduct.setSize(50, 50);
		lbCodeProduct.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lbCodeProduct, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		txtCodeProduct = new JTextField();
		txtCodeProduct.setText("" + (Partner.getIdConsecutive()));
		txtCodeProduct.setEnabled(true);
		add(txtCodeProduct, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 0.0;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel lbDateRegister = new JLabel("Date: ");
		lbDateRegister.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lbDateRegister, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		date = new JDateChooser();
		add(date, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 0.0;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel lbIdPartner = new JLabel("Id Partner: ");
		lbIdPartner.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lbIdPartner, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		txtIdParnet = new JTextField();
		ValidateFields.onlyNumber(txtIdParnet);
		add(txtIdParnet, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 0.0;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel lbQyuantity = new JLabel("Quantity");
		lbQyuantity.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lbQyuantity, gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		txtQuantity = new JTextField();
		ValidateFields.onlyLetter(txtQuantity);
		add(txtQuantity, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 0.0;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel lbIdRegistrer = new JLabel("Id Register: ");
		lbIdRegistrer.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lbIdRegistrer, gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		txtIdRegister = new JTextField();
		ValidateFields.onlyLetter(txtIdRegister);
		add(txtIdRegister, gbc);

		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel lbValue = new JLabel("Stratum: ");
		lbValue.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lbValue, gbc);

		spinerStratum = new JSpinner(new SpinnerNumberModel(1, 1, 6, 1));
		gbc.gridx = 1;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		add(spinerStratum, gbc);

		gbc.insets.set(20, 130, 2, -40);

		gbc.gridx = 0;
		gbc.gridy = 9;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 2.0;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;

		btnAdd = new JButton("Agregar Orden", new ImageIcon(getClass().getResource("/img/check.png")));
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBackground(Color.decode("#062f3c"));
		btnAdd.addActionListener(Controller.getInstance());
		btnAdd.setActionCommand(Actions.ADD_PARTNER.name());
		add(btnAdd, gbc);
	}

	/**
	 * Borra todos los campos del dialogo.
	 */
	public void cleanFields() {
		txtCodeProduct.setText("" + Partner.getIdConsecutive());
		txtIdParnet.setText("");
		txtQuantity.setText("");
		txtIdRegister.setText("");
		spinerStratum.setValue(1);
		date.setDate(null);
	}

	/**
	 * Crea un nuevo socio con la informacion del dialogo y lo retorna.
	 * 
	 * @return
	 */
	public Order getCreatedOrder() {
		return new Order(Integer.parseInt(txtIdRegister.getText()),date.getDate(),Integer.parseInt(txtIdParnet.getText()),
				Integer.parseInt(txtCodeProduct.getText()), Integer.parseInt(txtQuantity.getText()),
				Integer.parseInt(spinerStratum.getValue().toString()));
	}
	
	public static void main(String[] args) {
	JDialogRegisterOrder dialogRegisterOrder = new JDialogRegisterOrder();
	dialogRegisterOrder.setVisible(true);
	}
}
