package DataTypes;

import Utilities.DataReader;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeatProductMenu extends ProductMenu{

    Map<String, String> meatProducts = new HashMap<>();

    public MeatProductMenu(int userType){
        this.userType = userType;
        populateMeatProducts();
        initMenu(meatProducts);
    }

    private void populateMeatProducts(){
        File productInfoFile = new File("Database/ProductInfo.txt");
        File userProductFile = new File("Database/UserProduct.txt");

        List<String> meats = Arrays.asList(DataReader.readData(productInfoFile).entrySet().stream().filter(e -> e.getKey().equals("Meat"))
                .map(Map.Entry::getValue).toArray(String[]::new));


        if (userType == 0){
            File sellerInfoFile = new File("Database/SellerInfo.txt");


            filterByUserType(meats, userProductFile, sellerInfoFile);

        } else {
            File buyerInfoFile = new File("Database/BuyerInfo.txt");

            filterByUserType(meats, userProductFile, buyerInfoFile);
        }
    }
}
