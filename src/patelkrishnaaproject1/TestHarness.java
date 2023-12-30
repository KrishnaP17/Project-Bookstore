/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package patelkrishnaaproject1;
import java.util.*;
/**
 *
 * @author krp17
 */
public class TestHarness {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Bookstore krishna = new Bookstore();
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Welcome to our store!");

        int sum = 0;
        while(sum == 0){
        // TODO code application logic here
        
        System.out.println("What would you like to do?");
        System.out.println("\t 1. Make a Purchase");
        System.out.println("\t 2. Check inventory value");
        System.out.println("\t 3. View inventory");
        System.out.println("\t 4. Restock Items");
        System.out.println("\t 5. Compare item prices");
        System.out.println("\t 6. Make a return");
        System.out.println("\t 7. Join our membership");
        System.out.println("\t 8. Display members");

        int num = sc.nextInt();   
        
        switch(num){
            case 1:
                krishna.letsPurchaseItems();
                krishna.joinAMembership();
                break;
                
            case 2:
                System.out.println("The total of everything we have in stock right now is: " + krishna.inventoryValue());
                break;
            
            case 3:
                krishna.inventory();
                break;
        
            case 4:
                krishna.productID();
                System.out.println("Enter the product ID of the product you want to restock: ");
                int restockProductID = sc.nextInt();
                
                System.out.println("Enter the quantity you want to restock the product by: ");
                int restockQuantity = sc.nextInt();
                
                krishna.restockProduct(restockProductID,restockQuantity );
                break;
                
            case 5:
                krishna.productID();
                System.out.println("Enter the product Id of the product you want to compare (this product): ");
                int productID1 = sc.nextInt();
                
                System.out.println("Enter the product Id of the product you're comparing (other product): ");
                int productID2 = sc.nextInt();
                
                if(krishna.getStoreProducts().get(productID1-1).compareTo(krishna.getStoreProducts().get(productID2-1)) == -1){
                    System.out.println("This product is less priced than other product");
                    System.out.println("This is the price of this product: " + krishna.getStoreProducts().get(productID1-1).getPrice());
                    System.out.println("This is the price of other product: " + krishna.getStoreProducts().get(productID2-1).getPrice());

                }
                else if(krishna.getStoreProducts().get(productID1).compareTo(krishna.getStoreProducts().get(productID2)) == 1){
                    System.out.println("This product is more priced than other product");
                    System.out.println("This is the price of this product: " + krishna.getStoreProducts().get(productID1-1).getPrice());
                    System.out.println("This is the price of other product: " + krishna.getStoreProducts().get(productID2-1).getPrice());
                }
                else{
                    System.out.println("They are both the same price");
                    System.out.println("This is the price of this product: " + krishna.getStoreProducts().get(productID1-1).getPrice());
                    System.out.println("This is the price of other product: " + krishna.getStoreProducts().get(productID2-1).getPrice());
                }
                break;
        
            case 6:
                krishna.returnItem();
                System.out.println("Your item has been returned!, Thank You for considering us,have a great day!");
                break;
                
            case 7:
                krishna.joinAMembership();
                    break;
                
            case 8: 
                System.out.println("Do you want to display regular members or premium members? ");
                System.out.println("\t 1. Regular");
                System.out.println("\t 2. Premium");
                
                int whichDisplay = sc.nextInt();
                
                if(whichDisplay == 1){
                    krishna.displayRegMembers();
                }
                else if(whichDisplay == 2){
                    krishna.displayPremMembers();
                }
                else{
                    System.out.println("Invalid choice");
                }
            }
        }
    }     
}
    

