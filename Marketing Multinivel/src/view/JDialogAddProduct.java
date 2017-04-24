package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.Actions;
import controller.Controller;
import exceptions.ValidateFields;
import models.dao.Company;
import models.entities.Genre;
import models.entities.Product;

public class JDialogAddProduct extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField txtRef, txtLine, txtReference, txtPrice;
	private JComboBox<Genre> cbxGenre;
	private JButton btnAdd;

	public JDialogAddProduct() {
		setSize(500, 350);
		setModal(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("/img/product.png")).getImage());
		setTitle("Nuevo producto");
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLayout(new GridBagLayout());
		getContentPane().setBackground(Color.WHITE);
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.insets.set(0, 2, 2, 80);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0.5;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel lbRef = new JLabel("Ref: ");
		lbRef.setSize(50, 50);
		lbRef.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lbRef, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		txtRef = new JTextField("0");
		ValidateFields.onlyNumber(txtRef);
		add(txtRef, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 0.0;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel lbLine = new JLabel("Linea: ");
		lbLine.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lbLine, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		txtLine = new JTextField();
		add(txtLine, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 0.0;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel lbReference = new JLabel("Description: ");
		lbReference.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lbReference, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		txtReference = new JTextField();
		ValidateFields.onlyLetter(txtReference);
		add(txtReference, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 0.0;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel lbTarget = new JLabel("Target: ");
		lbTarget.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lbTarget, gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		cbxGenre = new JComboBox<>(Genre.values());
		cbxGenre.setSelectedItem(Genre.UNSPECIFIED);
		add(cbxGenre, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 0.0;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel lbPrice = new JLabel("Precio: ");
		lbPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lbPrice, gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		txtPrice = new JTextField("0");
		ValidateFields.onlyNumber(txtPrice);
		add(txtPrice, gbc);

		gbc.insets.set(20, 130, 3, -60);

		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 2.0;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		btnAdd = new JButton("Agregar producto", new ImageIcon(getClass().getResource("/img/check.png")));
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBackground(Color.decode("#062f3c"));

		btnAdd.addActionListener(Controller.getInstance());
		btnAdd.setActionCommand(Actions.ADD_PRODUCT.name());
		add(btnAdd, gbc);
	}

	public Product getProductToDialog() {
//		System.out.println((Genre)cbxGenre.getSelectedIndex());
		return Company.createProduct(Integer.parseInt(txtRef.getText()), 
				txtLine.getText(), txtReference.getText(),
				(Genre)cbxGenre.getSelectedItem(), Double.parseDouble(txtPrice.getText()));
	}

	public void cleanFields() {
		txtLine.setText("");
		txtRef.setText("0");
		txtReference.setText("");
		txtPrice.setText("0");
		cbxGenre.setSelectedItem(Genre.UNSPECIFIED);
	}
}
