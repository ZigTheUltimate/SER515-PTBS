package DataTypes;

public class Seller extends Person{
    public Seller(String username) {
        super(username);
    }

    @Override
    public void showMenu() {

    }

    @Override
    public ProductMenu createProductMenu() {
        return null;
    }
}
