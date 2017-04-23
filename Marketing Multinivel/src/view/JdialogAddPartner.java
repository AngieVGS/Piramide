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
import models.entities.Genre;
import models.entities.Partner;
import models.errores.ValidateFields;

public class JdialogAddPartner extends JDialog {
	private static final long serialVersionUID = 1L;
	private JLabel lbId, lbpartner;
	private JTextField txtId, txtIdLegal, txtName, txtSurname, txtPartner;
	private JSpinner spinerStratum;
	private JComboBox<Genre> cbxGenre;
	private JButton btnAdd;
	private JDateChooser registerDate, birthDate;

	public JdialogAddPartner() {
		setSize(450, 450);
		setModal(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("/img/iconAdd.png")).getImage());
		setTitle("Nuevo socio");
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
		lbId = new JLabel("Id: ");
		lbId.setSize(50, 50);
		lbId.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lbId, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		txtId = new JTextField();
		ValidateFields.onlyLetter(txtId);
		add(txtId, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 0.0;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel lbDateRegister = new JLabel("Fecha de registro: ");
		lbDateRegister.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lbDateRegister, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		registerDate = new JDateChooser();
		add(registerDate, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 0.0;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel lbIdLegal = new JLabel("Id Legal: ");
		lbIdLegal.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lbIdLegal, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		txtIdLegal = new JTextField();
		ValidateFields.onlyLetter(txtIdLegal);
		add(txtIdLegal, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 0.0;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel lbNumberProduct = new JLabel("Nombre: ");
		lbNumberProduct.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lbNumberProduct, gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		txtName = new JTextField();
		ValidateFields.onlyLetter(txtName);
		add(txtName, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 0.0;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel lbTypePerson = new JLabel("Apellido: ");
		lbTypePerson.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lbTypePerson, gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		txtSurname = new JTextField();
		ValidateFields.onlyLetter(txtSurname);
		add(txtSurname, gbc);

		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel lbTypeProduct = new JLabel("Genero: ");
		lbTypeProduct.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lbTypeProduct, gbc);

		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		cbxGenre = new JComboBox<>(Genre.values());
		cbxGenre.setSelectedItem(Genre.UNSPECIFIED);
		add(cbxGenre, gbc);

		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel lbDescription = new JLabel("Fecha de nacimiento: ");
		lbDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lbDescription, gbc);

		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		birthDate = new JDateChooser();
		add(birthDate, gbc);

		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel lbValue = new JLabel("Estrato: ");
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

		lbpartner = new JLabel("Socio: ");
		lbpartner.setHorizontalAlignment(SwingConstants.RIGHT);
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		add(lbpartner, gbc);

		gbc.gridx = 1;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		txtPartner = new JTextField();
		add(txtPartner, gbc);

		gbc.insets.set(20, 130, 2, -40);

		gbc.gridx = 0;
		gbc.gridy = 9;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 2.0;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		
		btnAdd = new JButton("Agregar socio", new ImageIcon(getClass().getResource("/img/check.png")));
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBackground(Color.decode("#062f3c"));
		btnAdd.addActionListener(Controller.getInstance());
		btnAdd.setActionCommand(Actions.ADD_PARTNER.name());
		add(btnAdd, gbc);
	}

	public void cleanFields() {
		txtId.setText("");
		txtIdLegal.setText("");
		txtName.setText("");
		txtSurname.setText("");
		txtPartner.setText("");
		spinerStratum.setValue(1);
		cbxGenre.setSelectedItem(Genre.UNSPECIFIED);
		registerDate.setDate(null);
		birthDate.setDate(null);
	}

	public Partner getCreatedPerson() {
		return new Partner(Integer.parseInt(txtId.getText()), txtName.getText(), birthDate.getDate());
	}
}