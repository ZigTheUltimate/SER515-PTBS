package DataTypes;

import Database.UserType;
import Utilities.DataReader;

import javax.swing.*;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ProductMenu extends JDialog {

    int userType;

    JTable productsTable;

    JPanel mainPanel;

    ProductMenu(UserType userType){
        this.userType = userType.ordinal();
    }


    public void initMenu(Map<String, String> productsList){
        mainPanel = new JPanel();


        Object[][] productsArray = productsList.entrySet().stream().map(e -> new String[]{e.getKey(), e.getValue()})
                .toArray(Object[][]::new);

        String[] columnNames = {"Product", "Seller"};

        productsTable = new JTable(productsArray, columnNames);

        mainPanel.add(productsTable);

        this.add(mainPanel);
        this.setModal(true);
        this.setVisible(true);

    }

    protected Map<String, String> filterByUserType(List<String> products, File userProductFile, File userInfoFile) {
        Map<String, String> result = new HashMap<>();

        List<String> users = Arrays.asList(DataReader.readData(userInfoFile).keySet().toArray(String[]::new));
        Map<String, String> allProducts;
        allProducts = DataReader.readData(userProductFile);

        for (Map.Entry<String, String> product:
                allProducts.entrySet()) {
            if (users.contains(product.getKey()) && products.contains(product.getValue())){
                result.put(product.getKey(), product.getValue());
            }
        }
        return result;
    }

}
