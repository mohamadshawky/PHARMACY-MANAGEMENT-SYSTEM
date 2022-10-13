package pharmacy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class User extends JFrame {
// class MyPanel extends JPanel{               
//    @Override
//    protected void paintComponent (Graphics g){             
//        super.paintComponent(g);          
//ImageIcon icon= new ImageIcon("supplierbg.png"); 
//Image m = icon.getImage();
//g.drawImage(m,0,0,getWidth(),getHeight(),this);    
//   }
//}
 
    public User() {
        //....................creation....................
 //labels & Imageicons for backgrounds
        //customer
        ImageIcon customerr = new ImageIcon("/images/customerbg.jpg");
        JLabel customerbg = new JLabel(customerr);
        
        //supplier
//      ImageIcon supplierr = new ImageIcon("images/supplierbg.jpg");
//        JLabel supplierbg = new JLabel(supplierr);
        
        //panels for tabedPanes
        JPanel customer = new JPanel();
        customer.setLayout(null);
        JPanel supplier = new JPanel();
        supplier.setLayout(null);
        
        //tabedPane
        JTabbedPane tp = new JTabbedPane();

        //customer tabedPane
        
        //buttons
        JButton add_customer = new JButton("Add order");
        JButton update_customer = new JButton("Update data");
        JButton delete_customer = new JButton("Delete order");
        JButton back_customer = new JButton("Back");
        JButton search_customer = new JButton("Search customer");
        JButton check_medicine_customer = new JButton("Check");             //to check if medicine found on store or not
        
        //labels
        JLabel ID_medicine_c = new JLabel("medicine ID:");
        JLabel medicine_name_c = new JLabel("medicine name:");
        JLabel amount_c = new JLabel("amount:");
        JLabel ID_customer_c = new JLabel("Customer ID:");
        JLabel customer_name_c = new JLabel("Customer name:");

        //textfields
        JTextField ID_medicine_field_c = new JTextField();
        JTextField medicine_name_field_c = new JTextField();
        JTextField amount_field_c = new JTextField();
        JTextField ID_customer_field_c = new JTextField();
        JTextField customer_name_field_c = new JTextField();

        //supplier tabedpane
        //buttons
        JButton add_supplier = new JButton("Add supplier");
        JButton update_supplier = new JButton("Update data");
        JButton delete_supplier = new JButton("Delete supplier");
        JButton search_supplier = new JButton("Search supplier");
        JButton back_supplier = new JButton("Back");

        //labels
        JLabel ID_supplier_s = new JLabel("Supplier ID:");
        JLabel company_name_s = new JLabel("Company name:");
        JLabel phone_number_s = new JLabel("Phone number:");
        JLabel company_address_s = new JLabel("Address:");

        //textfields
        JTextField ID_field_s = new JTextField();
        JTextField company_name_field_s = new JTextField();
        JTextField address_field_s = new JTextField();
        JTextField phone_field_s = new JTextField();

        //..............................Configuration.............................
        //tabedPanes
        tp.insertTab("Customer", null, customer, null, 0);
        tp.insertTab("Supplier", null, supplier, null, 1);        
        
        //customer
        //buttons
        add_customer.setBounds(50, 530, 140, 30);
        update_customer.setBounds(200, 530, 140, 30);
        delete_customer.setBounds(350, 530, 140, 30);
        search_customer.setBounds(500, 530, 140, 30);
        back_customer.setBounds(650, 530, 140, 30);
        check_medicine_customer.setBounds(720, 200, 80, 30);

        //labels
        ID_customer_c.setBounds(50, 10, 100, 100);
        customer_name_c.setBounds(50, 90, 100, 100);
        ID_medicine_c.setBounds(50, 170, 100, 100);
        medicine_name_c.setBounds(50, 250, 100, 100);
        amount_c.setBounds(50, 330, 100, 100);
        //customerbg.setLayout(null);             //for customer's background                 مشكله!!!
        
        //textfields
        ID_customer_field_c.setBounds(400, 45, 300, 20);
        customer_name_field_c.setBounds(400, 125, 300, 20);
        ID_medicine_field_c.setBounds(400, 205, 300, 20);
        medicine_name_field_c.setBounds(400, 285, 300, 20);
        amount_field_c.setBounds(400, 365, 300, 20);

        //supplier tabedPane
        //buttons
        add_supplier.setBounds(50, 530, 140, 30);
        update_supplier.setBounds(200, 530, 140, 30);
        delete_supplier.setBounds(350, 530, 140, 30);
        search_supplier.setBounds(500, 530, 140, 30);
        back_supplier.setBounds(650, 530, 140, 30);
        
        //labels
        ID_supplier_s.setBounds(50, 10, 100, 100);
        company_name_s.setBounds(50, 90, 100, 100);
        company_address_s.setBounds(50, 170, 100, 100);
        phone_number_s.setBounds(50, 250, 100, 100);
       //supplierbg.setLayout(null);                 //for supplier's background             //مشكله
        
        //textfields
        ID_field_s.setBounds(400, 45, 300, 20);
        company_name_field_s.setBounds(400, 125, 300, 20);
        address_field_s.setBounds(400, 205, 300, 20);
        phone_field_s.setBounds(400, 285, 300, 20);

        //.....................add...........................
        add(tp);             //add tabedpane on the form

        //components for customer tabedPane
        //labels
        customer.add(ID_medicine_c);
        customer.add(medicine_name_c);
        customer.add(amount_c);
        customer.add(ID_customer_c);
        customer.add(customer_name_c);
        customer.add(customerbg);       //add background

        //textfields
        customer.add(ID_medicine_field_c);
        customer.add(medicine_name_field_c);
        customer.add(customer_name_field_c);
        customer.add(ID_customer_field_c);
        customer.add(amount_field_c);

        //customer buttons
        customer.add(add_customer);
        customer.add(update_customer);
        customer.add(delete_customer);
        customer.add(back_customer);
        customer.add(search_customer);
        customer.add(check_medicine_customer);
                 
        //components for supplier tabedPane
        //labels
        supplier.add(ID_supplier_s);
        supplier.add(company_name_s);
        supplier.add(company_address_s);
        supplier.add(phone_number_s);
        //supplier.add(supplierbg);               //add background

        //textfields
        supplier.add(ID_field_s);
        supplier.add(company_name_field_s);
        supplier.add(address_field_s);
        supplier.add(phone_field_s);

        //buttons for supplier tapedpane
        supplier.add(add_supplier);
        supplier.add(update_supplier);
        supplier.add(delete_supplier);
        supplier.add(back_supplier);
        supplier.add(search_supplier);

        //..............................Events............................
        
        ////////CUSTOMER BUTTONS/////////
        //back_customer button 
        back_customer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main = new Main();
                dispose();
                main.setVisible(true);
            }
        });
        
        //add_customer button
        add_customer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String customer_id = ID_customer_field_c.getText();
                String customer_name = customer_name_field_c.getText();
                String medicine_id = ID_medicine_field_c.getText();
                String medicine_name = medicine_name_field_c.getText();
                String medicine_amount = amount_field_c.getText();
                 try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "root");
                    PreparedStatement s = c.prepareStatement("insert into customer (customer_id,customer_name) values(?,?)");
                    s.setString(1, customer_id);
                    s.setString(2, customer_name);
                    PreparedStatement m = c.prepareStatement("insert into customer_medicine (customer_id,medicine_id,customer_amount) values(?,?,?)");
                    m.setString(1, customer_id);
                    m.setString(2, medicine_id);
                    m.setString(3, medicine_amount);
                    int result = s.executeUpdate();     //executeUpdate() returns binary 1 or 0
                    int result2 = m.executeUpdate();
                    if (result == 1 && result2 == 1)
                            JOptionPane.showMessageDialog(null, "Record has been added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    ID_customer_field_c.setText("");
                    customer_name_field_c.setText("");
                    ID_medicine_field_c.setText("");
                    medicine_name_field_c.setText("");
                    amount_field_c.setText("");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "MySQL Connector is not found! !", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Driver Connector is not found! !", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //update_customer button
        update_customer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String customer_id = ID_customer_field_c.getText();
                String customer_name = customer_name_field_c.getText();
                String medicine_id = ID_medicine_field_c.getText();
                String medicine_name = medicine_name_field_c.getText();
                String medicine_amount = amount_field_c.getText();
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "root");
                    PreparedStatement s = c.prepareStatement("update customer set customer_name = '"+customer_name+"'where customer_id = '"+customer_id+"'");
                    int result = s.executeUpdate();     //executeUpdate() returns binary 1 or 0 
                    PreparedStatement m = c.prepareStatement("update customer_medicine set medicine_id = '"+medicine_id+"',customer_amount = '"+medicine_amount+"'where customer_id = '"+customer_id+"'");
                    int result2 = m.executeUpdate();
                    if (result == 1 && result2 == 1)
                            JOptionPane.showMessageDialog(null, "Record has been Update successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    ID_customer_field_c.setText("");
                    customer_name_field_c.setText("");
                    ID_medicine_field_c.setText("");
                    medicine_name_field_c.setText("");
                    amount_field_c.setText("");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "MySQL Connector is not found! !", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Driver Connector is not found! !", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //delete_customer button
        delete_customer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String customer_id = ID_customer_field_c.getText();
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "root");
                    PreparedStatement s = c.prepareStatement("delete from customer where customer_id ="+customer_id);
                    int result = s.executeUpdate();     //executeUpdate() returns binary 1 or 0
                    PreparedStatement m = c.prepareStatement("delete from customer_medicine where customer_id ="+customer_id);
                    int result2 = m.executeUpdate();
                    if (result == 1 && result2 == 1)
                            JOptionPane.showMessageDialog(null, "Record has been deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    ID_customer_field_c.setText("");
                    customer_name_field_c.setText("");
                    ID_medicine_field_c.setText("");
                    medicine_name_field_c.setText("");
                    amount_field_c.setText("");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "MySQL Connector is not found! !", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Driver Connector is not found! !", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //search_customer button
        search_customer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String customer_id = ID_customer_field_c.getText();
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "root");
                    PreparedStatement s = c.prepareStatement("select * from customer where customer_id = "+customer_id);
                    ResultSet rs = s.executeQuery();
                    if(rs.next()){
                        customer_name_field_c.setText(rs.getString("customer_name"));
                    }else{
                        JOptionPane.showMessageDialog(null, "MySQL Connector is not found! !", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    PreparedStatement m = c.prepareStatement("select * from customer_medicine where customer_id = "+customer_id);
                    ResultSet res = m.executeQuery();
                    if(res.next()){
                        amount_field_c.setText(rs.getString("customer_amount"));
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "MySQL Connector is not found! !", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Driver Connector is not found! !", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //////////SUPPLIER BUTTONS///////////////
        //add_supplier button 
        add_supplier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String S_id = ID_field_s.getText();                           //supplier id
                String supplier_name = company_name_field_s.getText();        //company name
                String supplier_address = address_field_s.getText();          //company address
                String supplier_phone = phone_field_s.getText();              //company phone number
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "root");
                    PreparedStatement s = c.prepareStatement("insert into supplier (supplier_name,supplier_address,supplier_phone) values(?,?,?)");
                    s.setString(1, supplier_name);
                    s.setString(2, supplier_address);
                    s.setString(3, supplier_phone);
                    int result = s.executeUpdate();     //executeUpdate() returns binary 1 or 0 
                    if (result == 1)
                            JOptionPane.showMessageDialog(null, "Record has been added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    company_name_field_s.setText("");
                    address_field_s.setText("");
                    phone_field_s.setText("");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "MySQL Connector is not found! !", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Driver Connector is not found! !", "Error", JOptionPane.ERROR_MESSAGE);

                }

            }
        });
        
        //update_supplier button
         update_supplier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String S_id = ID_field_s.getText();                           //supplier id
                String supplier_name = company_name_field_s.getText();        //company name
                String supplier_address = address_field_s.getText();          //company address
                String supplier_phone = phone_field_s.getText();
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "root");
                    PreparedStatement s = c.prepareStatement("update supplier set supplier_name = '"+supplier_name+"' ,supplier_address = '"+supplier_address+"',supplier_phone= '"+supplier_phone+"' where supplier_id = '"+S_id+"'");
                    int result = s.executeUpdate();     //executeUpdate() returns binary 1 or 0 
                    if (result == 1)
                            JOptionPane.showMessageDialog(null, "Record has been Update successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    company_name_field_s.setText("");
                    address_field_s.setText("");
                    phone_field_s.setText("");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "MySQL Connector is not found! !", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Driver Connector is not found! !", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
         
         //delete_supplier button
         delete_supplier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String S_id = ID_field_s.getText();                           //supplier id
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "root");
                    PreparedStatement s = c.prepareStatement("delete from supplier where supplier_id ="+S_id);
                    int result = s.executeUpdate();     //executeUpdate() returns binary 1 or 0 
                    if (result == 1)
                            JOptionPane.showMessageDialog(null, "Record has been deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    company_name_field_s.setText("");
                    address_field_s.setText("");
                    phone_field_s.setText("");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "MySQL Connector is not found! !", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Driver Connector is not found! !", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
         
         //search_supplier button
         search_supplier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String S_id = ID_field_s.getText();                           //supplier id
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "root");
                    PreparedStatement s = c.prepareStatement("select * from supplier where supplier_id = "+S_id);
                    ResultSet rs = s.executeQuery();
                    if(rs.next()){
                        company_name_field_s.setText(rs.getString("supplier_name"));
                        address_field_s.setText(rs.getString("supplier_address"));
                        phone_field_s.setText(rs.getString("supplier_phone"));
                    }else{
                        JOptionPane.showMessageDialog(null, "MySQL Connector is not found! !", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "MySQL Connector is not found! !", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Driver Connector is not found! !", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
         
        // back_supplier button
        back_supplier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main = new Main();
                dispose();
                main.setVisible(true);
            }
        });
        
        //....................................form....................................
        setTitle("User");
        Dimension D = new Dimension(850, 650);
        setSize(D);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

}
