package pharmacy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.layout.Background;
public class Login extends JFrame {
    public Login() {
        //.......................creation........................
        ImageIcon icon = new ImageIcon("images/Loginbg.jpg");        //background
        JLabel lbl = new JLabel(icon);                               //label to contain background & components   
        
        JLabel admin = new JLabel("Adminstrstor:");                  //adminstrator label
        JLabel pw = new JLabel("Password:");                         //password label
        JTextField adminf = new JTextField(20);                      //admin textfield
        JPasswordField psf = new JPasswordField(20);                 //password field
        JButton login = new JButton("Login");                        //login button
        JButton exit = new JButton("Exit");                          //login button
        //.........................configuration.................................
         lbl.setLayout(null);
       
        admin.setBounds(70, 40, 80, 15);
        pw.setBounds(70, 70, 80, 40);
        adminf.setBounds(300, 40, 200, 20);
        psf.setBounds(300, 75, 200, 20);
        login.setBounds(190, 200, 100, 20);
        exit.setBounds(305, 200, 100, 20);
        //........................add components on the form............................
        lbl.add(admin);
        lbl.add(adminf);
        lbl.add(pw);
        lbl.add(psf);
        lbl.add(login);
        lbl.add(exit);
        add(lbl);
        //....................................events...............................................
        //////////////LOGIN BUTTON////////////////////
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String admin = adminf.getText();
                String password = psf.getText();    //decrypt then get text
                 try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "root");
                    
                    PreparedStatement s = c.prepareStatement("select count(1) from admin where name = ? and password = ?");     //Count(1) to count the numbers of admins in DB
                    
                    int count = 0;
                    
                    s.setString(1, admin);
                    s.setString(2, password);
                    
                     ResultSet rs = s.executeQuery();           //execute the rows' fields
                     
                     while (rs.next())
                     {
                     count = rs.getInt("count(1)");             //returns numbers of rows that contain the data needed   
                     
                     }
                    if (count == 1)
                    {
                    JOptionPane.showMessageDialog(null, "Login Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    Main main = new Main();
                    dispose();
                    main.setVisible(true);
                    }  
                    else
                    {
                    JOptionPane.showMessageDialog(null, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                    adminf.setText("");
                    psf.setText(""); 
                    }           
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "MySQL Connector is not found! !", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Driver Connector is not found! !", "Error", JOptionPane.ERROR_MESSAGE);

                }
//                
            }
        });
        //////////////////EXIT BUTTON//////////////////
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        //......................................form.....................................
        setTitle("Login");
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    public static void main(String[] args) {
        Login l = new Login();      
    }

}
