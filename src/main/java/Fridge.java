import java.util.HashMap;
import java.util.Map;

public class Fridge {

    private String product;
    private String expirationDate;
    private Integer quantity;

    private HashMap <String,Integer> productInventory;
    private HashMap <String,String> expirationDates;

    public Fridge (String product, String ExpirationDate, Integer quantity) {
        this.product = product;
        this.expirationDate = expirationDate;
        this.quantity = quantity;

        Map productInventory = new HashMap<String, Integer>();
        Map expirationDates = new HashMap<String, String>();

    }

    public Fridge (){
        Map productInventory = new HashMap<String, Integer>();
        Map expirationDates = new HashMap<String, String>();

    }

    public void addItem(String product, Integer quantity, String expirationDate){
        productInventory.put(product, quantity);
        expirationDates.put(product,expirationDate);
    }

    public void removeItem(String product){
        productInventory.remove(product);
        expirationDates.remove(product);
    }



}
