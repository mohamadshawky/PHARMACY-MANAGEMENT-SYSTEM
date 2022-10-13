/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacy;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Product extends JFrame {

    public Product() {
        //........................create.......................
        //panels for tabedPanes
        JPanel manage = new JPanel();
        manage.setLayout(null);

        JPanel buy = new JPanel();
        buy.setLayout(null);

        JPanel sell = new JPanel();
        sell.setLayout(null);

        JTabbedPane tp = new JTabbedPane();             //TabedPane that contains Tabedpanels

        //manage tabedPane
        //buttons
        JButton add_product_m = new JButton("Add product");
        JButton update_product_m = new JButton("Update Product");
        JButton delete_product_m = new JButton("Delete product");
        JButton search_product_m = new JButton("Search");
        JButton back_manage_m = new JButton("Back");

        //textfields
        JTextField ID_field_m = new JTextField();
        JTextField company_name_field_m = new JTextField();
        JTextField address_field_m = new JTextField();
        JTextField phone_field_m = new JTextField();
        JTextField ID_medicine_field_m = new JTextField();
        JTextField medicine_name_field_m = new JTextField();
        JTextField price_field_m = new JTextField();

        //labels
        JLabel ID_supplier_m = new JLabel("Supplier ID:");
        JLabel company_name_m = new JLabel("Company name:");
        JLabel phone_number_m = new JLabel("Phone number:");
        JLabel ID_medicine_m = new JLabel("medicine ID:");
        JLabel medicine_name_m = new JLabel("medicine name:");
        JLabel price_m = new JLabel("price:");
        JLabel company_address_m = new JLabel("Address:");

        //buy tabedPane
        //buttons
        JButton buy_product = new JButton("Purchase product");
        JButton back_buy = new JButton("Back");

        //labels
        JLabel ID_company_buy = new JLabel("Company ID:");
        JLabel ID_medicine_buy = new JLabel("medicine ID:");
        JLabel product_amount_buy = new JLabel("amount to buy:");

        //textfields
        JTextField ID_company_field_buy = new JTextField();
        JTextField ID_medicine_field_buy = new JTextField();
        JTextField product_amount_field_buy = new JTextField();

        //sell tabedPane
        //labels
        JLabel ID_company_sell = new JLabel("Company ID:");
        JLabel ID_medicine_sell = new JLabel("medicine ID:");
        JLabel product_amount_sell = new JLabel("amount to sell:");

        //textfields
        JTextField ID_company_field_sell = new JTextField();
        JTextField ID_medicine_field_sell = new JTextField();
        JTextField product_amount_field_sell = new JTextField();

        //buttons
        JButton sell_product = new JButton("Sell product");
        JButton back_sell = new JButton("Back");

        //..................Configuration...................
        tp.insertTab("Manage", null, manage, null, 0);
        tp.insertTab("Purchase", null, buy, null, 1);
        tp.insertTab("Sell", null, sell, null, 2);

        //manage tabedpane
        //buttons
        add_product_m.setBounds(50, 530, 130, 30);
        update_product_m.setBounds(200, 530, 130, 30);
        delete_product_m.setBounds(350, 530, 130, 30);
        search_product_m.setBounds(500, 530, 130, 30);
        back_manage_m.setBounds(650, 530, 130, 30);

        //labels
        ID_supplier_m.setBounds(50, 0, 100, 100);
        company_name_m.setBounds(50, 50, 100, 100);
        company_address_m.setBounds(50, 100, 100, 100);
        phone_number_m.setBounds(50, 150, 100, 100);
        ID_medicine_m.setBounds(50, 200, 100, 100);
        medicine_name_m.setBounds(50, 250, 100, 100);
        price_m.setBounds(50, 300, 100, 100);

        //textfields
        ID_field_m.setBounds(400, 35, 300, 20);
        company_name_field_m.setBounds(400, 85, 300, 20);
        address_field_m.setBounds(400, 135, 300, 20);
        phone_field_m.setBounds(400, 185, 300, 20);
        ID_medicine_field_m.setBounds(400, 235, 300, 20);
        medicine_name_field_m.setBounds(400, 285, 300, 20);
        price_field_m.setBounds(400, 335, 300, 20);

        //purchase tabedpane
        //buttons
        buy_product.setBounds(250, 530, 150, 30);
        back_buy.setBounds(410, 530, 150, 30);

        //labels
        ID_company_buy.setBounds(50, 10, 100, 100);
        ID_medicine_buy.setBounds(50, 90, 100, 100);
        product_amount_buy.setBounds(50, 170, 100, 100);

        //textfields
        ID_company_field_buy.setBounds(400, 45, 300, 20);
        ID_medicine_field_buy.setBounds(400, 125, 300, 20);
        product_amount_field_buy.setBounds(400, 205, 300, 20);

        //sell tabedpane
        //buttons
        sell_product.setBounds(250, 530, 150, 30);
        back_sell.setBounds(410, 530, 150, 30);

        //labels
        ID_company_sell.setBounds(50, 10, 100, 100);
        ID_medicine_sell.setBounds(50, 90, 100, 100);
        product_amount_sell.setBounds(50, 170, 100, 100);

        //textfields
        ID_company_field_sell.setBounds(400, 45, 300, 20);
        ID_medicine_field_sell.setBounds(400, 125, 300, 20);
        product_amount_field_sell.setBounds(400, 205, 300, 20);

        //......................add........................
        add(tp);        //add tabedpane on the form

        //manage tabedpane
        //buttons
        manage.add(add_product_m);
        manage.add(update_product_m);
        manage.add(delete_product_m);
        manage.add(search_product_m);
        manage.add(back_manage_m);

        //labels
        manage.add(ID_supplier_m);
        manage.add(company_name_m);
        manage.add(company_address_m);
        manage.add(phone_number_m);
        manage.add(medicine_name_m);
        manage.add(price_m);
        manage.add(ID_medicine_m);

        //textfields
        manage.add(ID_field_m);
        manage.add(company_name_field_m);
        manage.add(address_field_m);
        manage.add(phone_field_m);
        manage.add(medicine_name_field_m);
        manage.add(price_field_m);
        manage.add(ID_medicine_field_m);

        //purchase tabedpane
        //buttons
        buy.add(buy_product);
        buy.add(back_buy);

        //labels
        buy.add(ID_company_buy);
        buy.add(ID_medicine_buy);
        buy.add(product_amount_buy);
        //buy.add(product_price_buy);

        //textfields
        buy.add(ID_company_field_buy);
        buy.add(ID_medicine_field_buy);
        buy.add(product_amount_field_buy);

        //sell tabedpane
        //buttons
        sell.add(sell_product);
        sell.add(back_sell);

        //labels
        sell.add(ID_company_sell);
        sell.add(ID_medicine_sell);
        sell.add(product_amount_sell);

        //textfields
        sell.add(ID_company_field_sell);
        sell.add(ID_medicine_field_sell);
        sell.add(product_amount_field_sell);

        //.....................Events...........................
        ///////////////////ADD PRODUCT//////////////////////
        add_product_m.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String S_id = ID_field_m.getText();                                   //supplier id
//                String supplier_name = company_name_field_m.getText();                //company name
//                String supplier_address = address_field_m.getText();                  //company address
//                String supplier_phone = phone_field_m.getText();                      //company phone
//                String M_id = ID_medicine_field_m.getText();                          //medicine id
                String medicine_name = medicine_name_field_m.getText();               //medicine name
                double medicine_price = Double.parseDouble(price_field_m.getText());  //medicine price

                int count = 0;

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "root");

                    PreparedStatement s_med = c.prepareStatement("select medicne_id from medicine");    //to select medicine id
                    ResultSet rs2 = s_med.executeQuery();                                               //for medicine_id which is AI
                    while (rs2.next()) {
                        String get_medicine_id[] = {rs2.getString(1)};
                    }
                    PreparedStatement s_sup = c.prepareStatement("select count(1) from supplier where supplier_id = '" + S_id + "'");  //to select supplier id from text field to DB
                    ResultSet rs = s_sup.executeQuery();                                              //for supplier data
                    while (rs.next()) {
                        count = rs.getInt("count(1)");
                    }
                    if (count == 0) {
                        JOptionPane.showMessageDialog(null, "supplier not found on suppliers data base, create a record for supplier", "ERROR", JOptionPane.QUESTION_MESSAGE);
                        ID_field_m.setText("");
                        medicine_name_field_m.setText("");
                        price_field_m.setText("");
                    }
                    if (count == 1) {
                        while (rs.next()) {
                            String sup_data[] = {rs.getString(3), rs.getString(4)};
                        }
                        PreparedStatement i = c.prepareStatement(
                                "insert into medicine  (medicine_name,medicine_price) values (?,?)");        //to insert medicine data
                        i.setString(1, medicine_name);
                        i.setDouble(2, medicine_price);
                    }
                    JOptionPane.showMessageDialog(null, "medicine added to products successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "MySQL Connector is not found! !", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Driver Connector is not found! !", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        ////////////////MANAGE BACK//////////////////// 
        back_manage_m.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                Main main = new Main();
                dispose();
                main.setVisible(true);
            }
        }
        );
        ///////////////PURCHASE BACK/////////////////// 
        back_buy.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                Main main = new Main();
                dispose();
                main.setVisible(true);
            }
        }
        );
        /////////////////////SUPPLIER BACK//////////////////// 
        back_sell.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                Main main = new Main();
                dispose();
                main.setVisible(true);
            }
        }
        );

        //...............................form.......................................
        setTitle(
                "Product");
        Dimension D = new Dimension(850, 650);

        setSize(D);

        setLocationRelativeTo(
                null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(
                true);
    }
}
