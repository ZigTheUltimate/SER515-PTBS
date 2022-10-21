import DataTypes.Buyer;
import DataTypes.Person;
import DataTypes.Seller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Login extends JDialog implements ActionListener {
    private static JLabel password1, label;
    private static JTextField username;
    private static JButton button;
    private static JPasswordField Password;

    Person user;

    Map<String, String> buyers = new HashMap<>();
    Map<String, String> sellers = new HashMap<>();

    Login(){
        System.out.println("Login.Login");
        this.setLayout(null);


        // Username label constructor
        label = new JLabel("Username");
        label.setBounds(100, 8, 70, 20);
        this.add(label);

        // Username TextField constructor
        username = new JTextField();
        username.setBounds(100, 27, 193, 28);
        this.add(username);

        // Password Label constructor
        password1 = new JLabel("Password");
        password1.setBounds(100, 55, 70, 20);
        this.add(password1);

        // Password TextField
        Password = new JPasswordField();
        Password.setBounds(100, 75, 193, 28);
        this.add(Password);

        // Button constructor
        button = new JButton("Login");
        button.setBounds(100, 110, 90, 25);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.addActionListener(this);
        this.add(button);
        this.setMinimumSize(new Dimension(500, 500));
        this.setSize(800, 800);
        this.setModal(true);




        File buyersInfo = new File("Database/BuyerInfo.txt");

        File sellersInfo = new File("Database/SellerInfo.txt");

        try {
            BufferedReader buyerBF = new BufferedReader(new FileReader(buyersInfo));
            BufferedReader sellerBF = new BufferedReader((new FileReader(sellersInfo)));

            String line;

            while ((line = buyerBF.readLine()) != null){
                buyers.put(line.split(":")[0], line.split(":")[1]);
            }
            System.out.println(buyers.toString());

            while ((line = sellerBF.readLine()) != null){
                sellers.put(line.split(":")[0], line.split(":")[1]);
            }
            System.out.println(sellers.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Login.actionPerformed");
        String Username = username.getText();
        String Password1 = Password.getText();

        if (buyers.containsKey(Username)){
            if (Password1.equals(buyers.get(Username))){
                user = new Buyer(Username);
                setVisible(false);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect Password");
            }
        } else if (sellers.containsKey(Username)){
            if (Password1.equals(sellers.get(Username))){
                user = new Seller(Username);
                setVisible(false);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect Password");
            }
        } else {
            JOptionPane.showMessageDialog(null, "User doesn't exist");
        }
    }

    public Person showLogin() {
        this.setVisible(true);
        return user;
    }
}
