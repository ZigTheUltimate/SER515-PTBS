package DataTypes;

import Utilities.DataReader;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProduceProductMenu extends ProductMenu{


    Map<String, String> produceProducts = new HashMap<>();

    public ProduceProductMenu(int userType){
        this.userType = userType;
        populateMeatProducts();
        initMenu(produceProducts);
    }

    private void populateMeatProducts(){
        File productInfoFile = new File("Database/ProductInfo.txt");
        File userProductFile = new File("Database/UserProduct.txt");

        List<String> meats = Arrays.asList(DataReader.readData(productInfoFile).entrySet().stream().filter(e -> e.getKey().equals("Produce"))
                .map(Map.Entry::getValue).toArray(String[]::new));


        if (userType == 0){
            File sellerInfoFile = new File("Database/SellerInfo.txt");


            produceProducts = filterByUserType(meats, userProductFile, sellerInfoFile);

        } else {
            File buyerInfoFile = new File("Database/BuyerInfo.txt");

            produceProducts = filterByUserType(meats, userProductFile, buyerInfoFile);
        }
    }


}
