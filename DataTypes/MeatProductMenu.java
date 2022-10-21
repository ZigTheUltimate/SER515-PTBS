package DataTypes;

import javax.swing.*;
import java.io.*;

import java.util.HashMap;
import java.util.Map;

public class MeatProductMenu extends ProductMenu{
    int userType;

    Map<String, String> meatProducts = new HashMap<>();

    JTable productsList;

    public MeatProductMenu(int userType){
        this.userType = userType;
        initMenu();
    }

    @Override
    public void initMenu() {
        File userProduct = new File("Database/UserProduct.txt");
        File buyersInfo = new File("Database/BuyerInfo.txt");
        File sellersInfo = new File("Database/SellerInfo.txt");
        BufferedReader buyerBF;
        BufferedReader sellerBF;
        BufferedReader productBF;


        String line;

        try{
            productBF = new BufferedReader(new FileReader(userProduct));

            if(userType == 0){
                Map<String, String> sellers = new HashMap<>();
                sellerBF = new BufferedReader((new FileReader(sellersInfo)));
                while ((line = sellerBF.readLine()) != null){
                    sellers.put(line.split(":")[0], line.split(":")[1]);
                }
                while ((line = productBF.readLine()) != null){
                    Map.Entry<String, String> newEntry= Map.entry(line.split(":")[0], line.split(":")[1]);
                    if (sellers.containsKey(newEntry.getKey())){
                        meatProducts.put(newEntry.getKey(), newEntry.getValue());
                    }
                }

            } else if (userType == 1) {
                Map<String, String> buyers = new HashMap<>();
                buyerBF = new BufferedReader(new FileReader(buyersInfo));
                while ((line = buyerBF.readLine()) != null){
                    buyers.put(line.split(":")[0], line.split(":")[1]);
                }
            }

            Object[][] productsArray = meatProducts.entrySet().stream().map(e -> new String[]{e.getKey(), e.getValue()})
                    .toArray(Object[][]::new);

            String[] columnNames= {"Product", "Seller"};

            productsList = new JTable(productsArray, columnNames);

        } catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}
