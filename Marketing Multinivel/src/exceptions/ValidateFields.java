package exceptions;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ValidateFields {
	
	public static void validateId(JTextField jTextField)throws ErrorDates{
		if (jTextField.getText().equals("")) {
			throw new ErrorDates("Datos incompletos, el campo de Id esta vacio");
		}
	}
	
	public static void validateName(JTextField jTextField)throws ErrorDates{
		if (jTextField.getText().equals("")) {
			throw new ErrorDates("Datos incompletos, el campo de nombre esta vacio");
		}
	}
	
	public static void validateBrad(JTextField jTextField) throws ErrorDates{
		if (jTextField.getText().equals("")) {
			throw new ErrorDates("Datos incompletos, el campo de marca esta vacio");
		}
	}
	
	public static void validatePrece(JTextField jTextField) throws ErrorDates{
		if (jTextField.getText().equals("")) {
			throw new ErrorDates("Datos incompletos, el campo de precio esta vacio");
		}
	}
	
	public static void validateDescription(JTextArea textArea) throws ErrorDates{
		if (textArea.getText().equals("")) {
			throw new ErrorDates("Datos incompletos, el campo de Descripcion esta vacio");
		}
	}

	public static void onlyNumber(JTextField jTextField) {
		jTextField.addKeyListener(new KeyListener() {
			@SuppressWarnings("static-access")
			public void keyTyped(KeyEvent e) {
				Character character = e.getKeyChar();
				if (!character.isLetterOrDigit(character) || character.isLetter(character)) {
					e.consume();
				}
			}
			public void keyPressed(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
			}
		});
	}
	
	public static void onlyLetter(JTextArea jTextArea) {
		jTextArea.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				Character character = e.getKeyChar();
				if (!Character.isLetterOrDigit(character) || Character.isDigit(character)) {
					if (character.charValue() != ' ') {
						e.consume();
					}
				}
			}
			public void keyPressed(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
			}
		});
	}

	public static void onlyLetter(JTextField jTextField) {
		jTextField.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				Character character = e.getKeyChar();
				if (!Character.isLetterOrDigit(character) || Character.isDigit(character)) {
					if (character.charValue() != ' ') {
						e.consume();
					}
				}
			}
			public void keyPressed(KeyEvent e) {
				@SuppressWarnings("unused")
				Character character = e.getKeyChar();
			}
			public void keyReleased(KeyEvent e) {
			}
		});
	}
}