package java;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import Storage.JSONInventory;
import Storage.StorageService;
import org.apache.commons.lang3.StringUtils;


public class Fridge {

    private StorageService storageService; // This is a dependency/collaborator
    private Map<String, String> wordMap = new HashMap<>();
    private File file;

    private String product;
    private Integer expirationDate;
    private Integer quantity;

    public HashMap <String,Integer> productInventory = new HashMap<>();
    public HashMap <String,Integer> expirationDates = new HashMap<>();

    public Fridge() {
        this.product = product;
        this.expirationDate = expirationDate;
        this.quantity = quantity;

    }

    public Fridge(StorageService storageService) {
        this.storageService = storageService;

        String fullPathToFile = System.getProperty("user.home") + File.separator + "dictionary.json";
        this.file = new File(fullPathToFile);
    }

    public boolean loadFile(String fileName) {

        boolean loadSuccessful = true;
        try {
            this.wordMap = this.storageService.loadFile(file);
        } catch (IOException e) {
            loadSuccessful = false;
        }



        return loadSuccessful;
    }

    public boolean saveFile(String fileName) {
        try {
            String content = JSONInventory.convertMapToJsonString(this.wordMap);
            return this.storageService.saveFile(file, content);
        } catch (IOException e) {
            return false;
        }
    }


    public void addItem(String product, Integer quantity, Integer expirationDate){
        this.productInventory.put(product, quantity);
        this.expirationDates.put(product,expirationDate);
        System.out.println(product + " has been added ");
    }

    public void removeItem(String product){
        this.productInventory.remove(product);
        this.expirationDates.remove(product);
        System.out.println(product + " has been removed");
    }

    public Integer checkExpiration(String product){
        return this.expirationDates.get(product);
    }

    public Integer getQuantity (String product){
        return this.productInventory.get(product);
    }

}

