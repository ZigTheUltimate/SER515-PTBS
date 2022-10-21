package DataTypes;

public class Buyer extends Person{
    public Buyer(String username) {
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
