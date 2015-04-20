package rentalcar.ui;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import rentalcar.util.SpringUtilities;

import rentalcar.system.User;
import rentalcar.system.Database;

/** 
 * History is just like SimpleHistory, except that it
 * uses a custom TableModel.
 */
public class History extends JFrame 
{
    private boolean DEBUG = false;
    private JTable table;
    private JTextField filterText;
    private JTextField statusText;
    private TableRowSorter<MyTableModel> sorter;
    private JPanel contentPane;
        
    private static User user;

    public void checkUserType(String type) 
    {
      if (type.equals("customer")) 
      {
        setDataCustomer();
      } 
      else if (type.equals("service_manager")) 
      {
        setDataManager();
      } 
      else if (type.equals("admin")) 
      {
        setDataManager();
      }
    }

    public void setDataCustomer()
    {
        //TODO: Set Data for Customer
    }

    public void setDataManager()
    {
        //TODO: Set Data for ServiceManager
    }
    
    /** 
     * Update the row filter regular expression from the expression in
     * the text box.
     */
    private void newFilter() 
    {
        RowFilter<MyTableModel, Object> rf = null;
        //If current expression doesn't parse, don't update.
        try 
        {
            rf = RowFilter.regexFilter(filterText.getText());
        } 
        catch (java.util.regex.PatternSyntaxException e) 
        {
            return;
        }
        sorter.setRowFilter(rf);
    }

    public History(User loggedInUser) 
    {
        this.user = loggedInUser;
        contentPane = new JPanel();

        checkUserType(user.Type());
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        setBounds(100, 100, 800, 600);
                
        MyTableModel model = new MyTableModel();
        sorter = new TableRowSorter<MyTableModel>(model);

        table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(800, 600));
        table.setFillsViewportHeight(true);
        table.setRowSorter(sorter);

        //We have a single selection for our model.
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 
        //When selection changes, provide user with row numbers for
        //both view and model.
        table.getSelectionModel().addListSelectionListener
        (
            new ListSelectionListener() 
            {
                public void valueChanged(ListSelectionEvent event) 
                {
                    int viewRow = table.getSelectedRow();

                    if (viewRow < 0) 
                    {
                        //Selection got filtered away.
                        statusText.setText("");
                    } 
                    else 
                    {
                        int modelRow = table.convertRowIndexToModel(viewRow);
                        statusText.setText(String.format("Selected Row in view: %d. " 
                                        + "Selected Row in model: %d.", viewRow, modelRow));
                    }
                }
            }
        );

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        contentPane.add(scrollPane);

        //Create a separate form for filterText and statusText
        JPanel form = new JPanel(new SpringLayout());
        JLabel l1 = new JLabel("Filter Text:", SwingConstants.TRAILING);
        form.add(l1);
        filterText = new JTextField();

        //Whenever filterText changes, invoke newFilter.
        filterText.getDocument().addDocumentListener
        (
            new DocumentListener() 
            {
                public void changedUpdate(DocumentEvent e) 
                {
                    newFilter();
                }
                public void insertUpdate(DocumentEvent e) 
                {
                    newFilter();
                }
                public void removeUpdate(DocumentEvent e) 
                {
                    newFilter();
                }
            }
        );

        l1.setLabelFor(filterText);
        form.add(filterText);
        JLabel l2 = new JLabel("Status:", SwingConstants.TRAILING);
        form.add(l2);
        statusText = new JTextField();
        l2.setLabelFor(statusText);
        form.add(statusText);
        SpringUtilities.makeCompactGrid(form, 2, 2, 6, 6, 6, 6);
        //add(form);
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.add(contentPane);
        container.add(form);

        setContentPane(container);
        pack();
    }

    class MyTableModel extends AbstractTableModel 
    {
        Database db = new Database();
        int userID = user.getCustomerId();        

        private String[] columnNames = 
        {
            "Reservation ID",
            "Customer Name",
            "Class",
            "Vehicle",
            "Start Date",
            "End Date",
            "Total Amount"
        };

        private Object[][] data = 
        {
            {"1231465", "John Smith",
    	     "Minivan", "Toyota Sienna", "03-12-2015", "03-15-2015", new Double(255.00)},
    	    {"4561465", "Will Turner",
             "Std SUV", "Ford Explorer", "04-12-2015", "05-15-2015", new Double(2225.00)},
    	    {"8678865", "Ned Stark",
             "Std SUV", "Honda Pilot", "03-22-2015", "03-25-2015", new Double(225.00)},
    	    {"9793465", "Jon Snow",
             "Sm SUV", "Toyota RAV4", "01-12-2015", "03-15-2015", new Double(4010.00)},
    	    {"3331465", "Khal Drogo",
             "Standard", "Honda Accord", "02-12-2015", "03-15-2015", new Double(1900.00)},
            {"5555465", "Tyrion Lannister",
             "Compact", "Honda Civic", "03-01-2015", "03-15-2015", new Double(700.00)}
        };

        public int getColumnCount() 
        {
            return columnNames.length;
        }

        public int getRowCount() 
        {
            return data.length;
        }

        public String getColumnName(int col) 
        {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) 
        {
            return data[row][col];
        }

        /*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
         */
        public Class getColumnClass(int c) 
        {
            return getValueAt(0, c).getClass();
        }

        /*
         * Don't need to implement this method unless your table's
         * editable.
         */
        public boolean isCellEditable(int row, int col) 
        {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            if (col < 2) 
            {
                return false;
            } 
            else 
            {
                return true;
            }
        }

        /*
         * Don't need to implement this method unless your table's
         * data can change.
         */
        public void setValueAt(Object value, int row, int col) 
        {
            if (DEBUG) 
            {
                System.out.println("Setting value at " + row + "," + col
                                   + " to " + value
                                   + " (an instance of "
                                   + value.getClass() + ")");
            }

            data[row][col] = value;
            //fireTableCellUpdated(row, col);

            if (DEBUG) 
            {
                System.out.println("New value of data:");
                printDebugData();
            }
        }

        private void printDebugData() 
        {
            int numRows = getRowCount();
            int numCols = getColumnCount();

            for (int i=0; i < numRows; i++) 
            {
                System.out.print("    row " + i + ":");

                for (int j=0; j < numCols; j++) 
                {
                    System.out.print("  " + data[i][j]);
                }
                System.out.println();
            }
            System.out.println("--------------------------");
        }
    }
}
