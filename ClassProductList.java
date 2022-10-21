import java.util.Iterator;

public class ClassProductList<Product> implements Iterable{
    ReminderVisitor reminderVisitor;
    Product[] products;

    public void accept(NodeVisitor visitor){

    }

    @Override
    public Iterator iterator() {
        return new ProductIterator();
    }

}
