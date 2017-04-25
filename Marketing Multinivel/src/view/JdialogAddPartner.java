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
import models.entities.Partner;

/**
 * Dialogo para agregar Socio.
 * 
 * @author Yuliana Boyaca, Viviana Galindo, Dayan Ramirez, sebastian Rodriguez, Daniela Torres
 * 
 *
 */
public class JdialogAddPartner extends JDialog {
	private static final long serialVersionUID = 1L;
	private JLabel lbId, lbpartner;
	private JTextField txtId, txtIdLegal, txtName, txtSurname, txtParent;
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
		setTitle("New Partner");
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
		txtId.setText("" + (Partner.getIdConsecutive()));
		txtId.setEnabled(false);
		add(txtId, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 0.0;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel lbDateRegister = new JLabel("Register: ");
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
		JLabel lbIdLegal = new JLabel("Legal Id: ");
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
		ValidateFields.onlyNumber(txtIdLegal);
		add(txtIdLegal, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 0.0;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel lbNumberProduct = new JLabel("Name: ");
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
		JLabel lbTypePerson = new JLabel("Surname: ");
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
		JLabel lbTypeProduct = new JLabel("Genre: ");
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
		JLabel lbDescription = new JLabel("Birthdate: ");
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

		lbpartner = new JLabel("Id Parent: ");
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
		txtParent = new JTextField();
		ValidateFields.onlyNumber(txtParent);
		add(txtParent, gbc);

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

	/**
	 * Borra todos los campos del dialogo.
	 */
	public void cleanFields() {
		txtId.setText("" + Partner.getIdConsecutive());
		txtIdLegal.setText("");
		txtName.setText("");
		txtSurname.setText("");
		txtParent.setText("");
		spinerStratum.setValue(1);
		cbxGenre.setSelectedItem(Genre.UNSPECIFIED);
		registerDate.setDate(null);
		birthDate.setDate(null);
	}

	/**
	 * Crea un nuevo socio con la informacion del dialogo y lo retorna.
	 * 
	 * @return
	 */
	public Partner getCreatedPartner() {
		return new Partner(registerDate.getDate(),
				Integer.parseInt(txtIdLegal.getText()), txtName.getText(), txtSurname.getText(),
				(Genre) cbxGenre.getSelectedItem(), birthDate.getDate(),
				Integer.parseInt(spinerStratum.getValue().toString()), Integer.parseInt(txtParent.getText()));
	}
}