package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Actions;
import controller.Controller;

public class PanelActionsTable extends JPanel {

    private static final long serialVersionUID = 1L;
    public static final int T = 10;
    public static final String TYPE_WORD = "Arial Black";
    public static final String IMG_BUTTON_DETAILS = "/img/detalles.png";

    public PanelActionsTable() {
        setBackground(Color.WHITE);
        setLayout(new GridLayout(1, 3, 5, 8));

        JButton btnDetails = new JButton(new ImageIcon(getClass().getResource(IMG_BUTTON_DETAILS)));
        btnDetails.setBorderPainted(false);
        btnDetails.setToolTipText("Details");
        btnDetails.setBackground(Color.WHITE);
        btnDetails.setFont(new Font(TYPE_WORD, Font.PLAIN, T));
        btnDetails.setForeground(Color.WHITE);
        btnDetails.addActionListener(Controller.getInstance());
       btnDetails.setActionCommand(Actions.SHOW_ORDERS.name());
        add(btnDetails);

        JButton btnEdit = new JButton(new ImageIcon(getClass().getResource("/img/editar.png")));
        btnEdit.setBorderPainted(false);
        btnEdit.setToolTipText("Details");
        btnEdit.setBackground(Color.WHITE);
        btnEdit.addActionListener(Controller.getInstance());
        btnEdit.setFont(new Font(TYPE_WORD, Font.PLAIN, T));
        btnEdit.setForeground(Color.WHITE);
        btnEdit.setActionCommand(Actions.SHOW_DIALOG_EDIT_PARTNER.name());
        add(btnEdit);


    }
}
