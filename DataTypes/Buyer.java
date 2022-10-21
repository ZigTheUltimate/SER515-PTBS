package DataTypes;

import Database.UserType;
import Interfaces.ChoiceDialog;

import javax.swing.*;

public class Buyer extends Person {
    public Buyer(String username) {
        super(username);
    }

    @Override
    public void showMenu() {

    }

    @Override
    public ProductMenu createProductMenu() {
        return new MeatProductMenu(UserType.Buyer);
    }
}