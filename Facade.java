import javax.swing.*;

/*The interface class between the GUI and the underlining system, the
control logic and many of the operating functions are included in this class*/
public class Facade extends JFrame{
    private int UserType;
    //private Product theSelectedProduct;
    private int nProductCategory;
    //private ClassProductList theProductList;
    private Person thePerson;

    Facade(){
        this.setSize(800, 800);
        this.show();
    }

    public boolean login(){
        try {
            //create instance of the CreateLoginForm
            Login form = new Login();
            form.setModal(true);
            form.setSize(800,800);  //set size of the frame
            thePerson = form.showLogin();
            //make form visible to the user
        }
        catch(Exception e)
        {
            //handle exception
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


        return false;
    }

    public void addTrading(){}

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
