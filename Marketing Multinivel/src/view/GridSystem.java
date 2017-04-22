package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;

public class GridSystem {

    private static final int DEFAULT_COLUMN_WIDTH = 1;
    private static final int COLUMNS_NUMBER = 12;
    public static final Dimension INIT_DIMENSION = new Dimension(0, 0);

    private GridBagConstraints constraints;

    public GridSystem(Container component) {
        component.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        generateBasicGrid(component);
    }

    private void generateBasicGrid(Container component) {
        constraints.weightx = DEFAULT_COLUMN_WIDTH;
        for (int i = 0; i < COLUMNS_NUMBER; i++) {
            constraints.gridx = i;
            component.add(new JLabel(), constraints);
        }
    }

    /**
     *
     * @param row initial value is 1
     * @param column initial value is 0
     * @param width number between 1 and 12, is the columns number that fill the
     * component
     * @param height of the row
     * @return constrains with the new values
     */
    public GridBagConstraints insertComponent(int row, int column, int width, double height) {
        constraints.gridy = row;
        constraints.gridx = column;
        constraints.gridwidth = width;
        constraints.weighty = height;
        return constraints;
    }

    /**
     *
     * Keeps row and height
     *
     * @param column initial value is 0
     * @param width number between 1 and 12, is the columns number that fill the
     * component
     * @return constrains with the new values
     */
    public GridBagConstraints insertComponent(int column, int width) {
        constraints.gridx = column;
        constraints.gridwidth = width;
        return constraints;
    }

    /**
     * Add a border to the previous component
     *
     * @param top
     * @param right
     * @param bottom
     * @param left
     */
    public void addExternalBorder(int top, int right, int bottom, int left) {
        constraints.insets = new Insets(top, left, bottom, right);
    }
}
