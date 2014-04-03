import java.io.*;
import java.util.ArrayList;

public class InventorySystem{
  
  public static void main(String[] args){
    ArrayList<Item> inventory = new ArrayList<Item>();
    createInventory(inventory);
    print(inventory);
    System.out.println("size: " + inventory.size());
  }
  
  public static void createInventory(ArrayList<Item> inventory){
    BufferedReader fileIn = null;
    String inputLine = null;
    
    try{
      fileIn = new BufferedReader(new FileReader("items.txt"));
      inputLine = fileIn.readLine();
      while (inputLine != null){
        inventory.add(createItem(inputLine));
        inputLine = fileIn.readLine();
      }
      fileIn.close();
    }
    catch (IOException ioe){
      System.out.println(ioe.getMessage());
    }    
  }
  
  public static Item createItem(String input){
    String[] tokens = input.trim().split("\\s+");
    return new Item (tokens[0], tokens[1], Integer.parseInt(tokens[2]), Double.parseDouble(tokens[3]));
  }
  
  public static void print(ArrayList<Item> inventory){
    for (int i = 0; i <  inventory.size() -1; i++){
      System.out.println(inventory.get(i).toString()); 
    }
  }
}//class

///////////////////////////////////////////////////////////////////////////////////////////////
class Item{
  
  private String name;
  private String type;
  private int price;
  private double weight;
  
  public Item(String name, String type, int price, double weight){
    this.name = name;
    this.type = type;
    this.price = price; 
    this.weight = weight;
  }
  
  public String getName(){
    return name;
  }
  
  public String getType(){
    return type;
  }
  
  public int getPrice(){
    return price;
  }
  public void setPrice(int newPrice){
    price = newPrice;
  }
  
  public double getWeight(){
    return weight;
  }
  
  public String toString(){
    return "Item: " + name + "\tType: " + type + "\tPrice : " + price + "g\tWeight: " + weight + "lbs"; 
  }
}
