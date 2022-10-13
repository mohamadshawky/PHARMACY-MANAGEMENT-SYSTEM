package pharmacy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Main extends JFrame {
   public Main() {
        //..................creation ..........................
        JPanel p1 = new JPanel(new FlowLayout());             //for containing buttons
        JPanel p2 = new JPanel(new BorderLayout());         //for containing all components
        JPanel p3 = new JPanel(new BorderLayout());         //for containing table

        //customer, suppliers forms & check stock
        JButton userfrm = new JButton("Customer or supplier");
        JButton productfrm = new JButton("Product");
        JButton checkstock = new JButton("Check Stock");

        //...........................configuration..................................
        //............................add...................................  
        
        p1.add(userfrm);
        p1.add(productfrm);
        p1.add(checkstock);
        p2.add(p1, BorderLayout.SOUTH);
        p2.add(p3);
        add(p2);                            //مش عاوز ييجى فى نصف الفورم؟؟

        //.........................events............................
        ////////////////////USER FORM//////////////////////////////
        
        userfrm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = new User();
                dispose();
                user.setVisible(true);
            }
        });

        ////////////////////PRODUCT FORM//////////////////////
        
        productfrm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Product product = new Product();
                dispose();
                product.setVisible(true);
            }
        });

        ///////////////////CHECK STOCK/////////////////////
        
        checkstock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection c = null;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Driver Connector is not found! !", "Error", JOptionPane.ERROR_MESSAGE);
                }
                try {
                    c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "root");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "MySQL Connector is not found! !", "Error", JOptionPane.ERROR_MESSAGE);
                }
                PreparedStatement s;
                try {
                    s = c.prepareStatement("select * from medicine");
                    ResultSet rs = s.executeQuery();
                    while (rs.next()) {
                        String arr[] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "MySQL Connector is not found! !", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //..................................table....................................
        //create table model
        DefaultTableModel table_main = new DefaultTableModel();
        table_main.addColumn("medicine ID");
        table_main.addColumn("medicine name");
        table_main.addColumn("amount");
        table_main.addColumn("price");
        //end of table model
        table_main.addRow(new Object[]{"medicine ID", "medicine name", "amount", "price"});
        JTable tabel_main_form = new JTable();          //create table
        tabel_main_form.setBounds(0, 0, getWidth(), getHeight());        //configuration
        p3.add(tabel_main_form);                           //add table on the form
        tabel_main_form.setModel(table_main);           //add the table's model
        //.................................form.................................... 
        setTitle("Main");
        Dimension D = new Dimension(600, 400);
        setSize(D);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

}
