package rentalcar.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

/** 
 * History is just like SimpleHistory, except that it
 * uses a custom TableModel.
 */
public class History extends JPanel {
    private boolean DEBUG = false;

    public History() {

          
        super(new GridLayout(1,0));

        JTable table = new JTable(new MyTableModel());
        table.setPreferredScrollableViewportSize(new Dimension(800, 600));
        table.setFillsViewportHeight(true);
        table.setAutoCreateRowSorter(true);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }

    class MyTableModel extends AbstractTableModel {
        private String[] columnNames = {"Reservation ID",
                                        "Customer Name",
                                        "Class",
                                        "Vehicle",
                                        "Start Date",
                                        "End Date",
                                        "Total Amount"};
        private Object[][] data = {
	    {"1231465", "John Smith",
	     "Minivan", "Toyota Sienna", "03-12-2015",  "03-15-2015", new Double(255.00)},
	    {"4561465", "Will Turner",
         "Std SUV", "Ford Explorer", "04-12-2015",  "05-15-2015", new Double(2225.00)},
	    {"8678865", "Ned Stark",
         "Std SUV", "Honda Pilot", "03-22-2015",  "03-25-2015", new Double(225.00)},
	    {"9793465", "Jon Snow",
         "Sm SUV", "Toyota RAV4", "01-12-2015",  "03-15-2015", new Double(4010.00)},
	    {"3331465", "Khal Drogo",
         "Standard", "Honda Accord", "02-12-2015",  "03-15-2015", new Double(1900.00)},
        {"5555465", "Tyrion Lannister",
         "Compact", "Honda Civic", "03-01-2015",  "03-15-2015", new Double(700.00)}
        };

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        /*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
         */
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        /*
         * Don't need to implement this method unless your table's
         * editable.
         */
        public boolean isCellEditable(int row, int col) {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            if (col < 2) {
                return false;
            } else {
                return true;
            }
        }

        /*
         * Don't need to implement this method unless your table's
         * data can change.
         */
        public void setValueAt(Object value, int row, int col) {
            if (DEBUG) {
                System.out.println("Setting value at " + row + "," + col
                                   + " to " + value
                                   + " (an instance of "
                                   + value.getClass() + ")");
            }

            data[row][col] = value;
            //fireTableCellUpdated(row, col);

            if (DEBUG) {
                System.out.println("New value of data:");
                printDebugData();
            }
        }

        private void printDebugData() {
            int numRows = getRowCount();
            int numCols = getColumnCount();

            for (int i=0; i < numRows; i++) {
                System.out.print("    row " + i + ":");
                for (int j=0; j < numCols; j++) {
                    System.out.print("  " + data[i][j]);
                }
                System.out.println();
            }
            System.out.println("--------------------------");
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.

        JFrame frame = new JFrame("History");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(800,600);
        frame.setBounds(100, 100, 800, 600);
        
        JPanel contentPane = new JPanel();
        //Create and set up the content pane.
        History newContentPane = new History();
        
        newContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        newContentPane.setOpaque(true); //content panes must be opaque
        contentPane.add(newContentPane);
        frame.setContentPane(contentPane);
        //java.awt.Dimension.preferredSize(800,600);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                createAndShowGUI();
            }
        });
    }
}