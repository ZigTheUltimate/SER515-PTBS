package DataTypes;

public abstract class Person {
    private String username;

    private ProductMenu theProductMenu;

    public Person(String username){
        this.username = username;
    }

    public abstract void showMenu();

    public void showAddButton(){}

    public void showViewButton(){}

    public void showRadioButton(){}

    public void showLabels(){}

    public abstract ProductMenu createProductMenu();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
