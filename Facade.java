import DataTypes.Person;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*The interface class between the GUI and the underlining system, the
control logic and many of the operating functions are included in this class*/
public class Facade extends JFrame{
    private int UserType;
    //private Product theSelectedProduct;
    private int nProductCategory;
    //private ClassProductList theProductList;
    private Person thePerson;

    private JButton addTradeBtn = new JButton("Add Trade");
    private JButton viewTradeBtn = new JButton("View Trade");
    private JButton decideBidBtn = new JButton("Decide Bidding");
    private JButton discussBidBtn = new JButton("Discuss Bidding");
    private JButton submitBidBtn = new JButton("Submit Bidding");



    private JPanel mainPanel= new JPanel();

    private JPanel addTradePanel = new JPanel();

    Facade(){
        this.setSize(800, 800);
        mainPanel.add(addTradeBtn);
        mainPanel.add(viewTradeBtn);
        mainPanel.add(decideBidBtn);
        mainPanel.add(discussBidBtn);
        mainPanel.add(submitBidBtn);
        addTradeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTrading();
            }
        });

        viewTradeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: Implement View Trade Functionality
            }
        });

        decideBidBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: Implement Decide Bid
            }
        });

        discussBidBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: Implement Discuss Bid
            }
        });

        submitBidBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: Implement Submit Bid
            }
        });

        this.add(mainPanel);

        this.setVisible(true);
        login();
    }

    public boolean login(){
        try {
            //create instance of the CreateLoginForm
            Login form = new Login();
            form.setModal(true);
            form.setSize(800,800);  //set size of the frame
            thePerson = form.showLogin();
            System.out.println(thePerson.getUsername());
            //make form visible to the user
        }
        catch(Exception e)
        {
            //handle exception
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


        return false;
    }

    public void addTrading(){
        thePerson.createProductMenu(    );
    }

    public void viewTrading(){}

    public void decideBidding(){}

    public void discussBidding(){}

    public void submitBidding(){}

    public void remind(){}

    //public void createUser(UserInfoItem userInfoItem){}

    public void createProductList(){}

    public void AttachProductToUser(){}

    public void SelectProduct(){}

    public void productOperation(){}


}
