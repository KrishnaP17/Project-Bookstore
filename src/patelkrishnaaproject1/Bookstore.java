/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patelkrishnaaproject1;

import java.util.ArrayList;
import java.util.*;


/**
 *
 * @author krp17
 */
public class Bookstore implements BookStoreSpecification {
    
        
    private  ArrayList<Books> bookProducts = new ArrayList<Books>(); 
    private  ArrayList<CDs> cdProducts = new ArrayList<CDs>(); 
    private  ArrayList<DVDs> dvdProducts = new ArrayList<DVDs>(); 
    
    private ArrayList<Membership> regular = new ArrayList<Membership>();
    private ArrayList<PremiumMemberships> premium = new ArrayList<PremiumMemberships>();
    private ArrayList<Products> product = new ArrayList<Products>();
    
    private double totalPurchaseAmount = 0;
    
    private double totalCost = 0;

    private int quant = 1;
    
    private int totalNumBooks = 4;
    private int totalNumCDs = 3;
    private int totalNumDVDs = 3;
    
    Scanner sc = new Scanner(System.in);

    public Bookstore(){
        Books book1 = new Books("To Kill a Mockingbird (Book) ", 7.99, 1, 1);
        Books book2 = new Books("Catcher and the Rye (Book) ", 9.99, 2, 1);
        Books book3 = new Books("Rich Dad, Poor Dad (Book) ", 10.00, 3, 1);
        Books book4 = new Books("Percy Jackson (Book) ", 15.98, 4, 1);
        bookProducts.add(book1);
        bookProducts.add(book2);
        bookProducts.add(book3);
        bookProducts.add(book4);
        
        CDs cd1 = new CDs("Folklore: Taylor Swift (CD) ", 50.56, 5, 1);
        CDs cd2 = new CDs("After Hours (CD) ", 60.98, 6, 1);
        CDs cd3 = new CDs("Midnight Memories (CD) ", 40.33, 7, 1);
        cdProducts.add(cd1);
        cdProducts.add(cd2);
        cdProducts.add(cd3);

        DVDs dvd1 = new DVDs("The Hunger Games (DVD) ", 6.99, 8, 1);
        DVDs dvd2 = new DVDs("Megamind (DVD) ", 7.99, 9, 1);
        DVDs dvd3 = new DVDs("The Bad Games (DVD) ", 10.00, 10, 1);
        dvdProducts.add(dvd1);
        dvdProducts.add(dvd2);
        dvdProducts.add(dvd3);
        
        for(Products p1 : bookProducts){
            product.add(p1);
        }
        
        for(Products p2 : cdProducts){
            product.add(p2);
        }
        
        for(Products p3 : dvdProducts){
            product.add(p3);
        }
        
        Membership reg1 = new Membership("Krishna", 15.00);
        regular.add(reg1);
        
        PremiumMemberships prem1 = new PremiumMemberships("Krishna", 15, true);
        premium.add(prem1);
        
    }
    
    
    
    public ArrayList<Books> getBookProducts(){
       return this.bookProducts;
    }
    
    public ArrayList<CDs> getCDProducts(){
       return cdProducts;
    }
    
    public ArrayList<DVDs> getDVDProducts(){
       return dvdProducts;
    }
    
    public ArrayList<Products> getStoreProducts(){
        return product;
    }

    public int getTotalProducts(){
        return product.size();
    }
    
    public double getTotalCost(){
        return totalCost;
    }

    public void productID(){
        ArrayList<Products> productList = getStoreProducts();

        for(Products p : productList){
        System.out.println("\tID No. " + p.getProductID() + ". " +  p.getName());
        }
    }
    
    @Override
    public void restockProduct(int productID, int quantity) {
         ArrayList<Products> productList = getStoreProducts();
            
            for(Products p : productList){
                if(productID == p.getProductID()){
                    quant += quantity;
                    productList.get(productID-1).setQuantity(quant);
                    System.out.println("You restocked " + p.getName() + ". Now we have " + quant + " quantity of that product. Restock successful!" );
                }
            }
    }
    
    //ASK
    @Override
    public double inventoryValue() {
        //print out the value of everything in stock 
        double temp = 0;
            ArrayList<Products> productList = getStoreProducts();
            
            for(Products p : productList){
                //
                 p.setPrice(p.getPrice()*p.getQuantity());
                //
                 temp += p.getPrice();
            }
            return temp;
    }

    //ASK
    public void inventory(){
         System.out.println( "There are " + totalNumBooks + " of books in our inventory. \n There are " + totalNumCDs + " types of cds in our inventory. \n There are " + totalNumDVDs + " types of dvds in our inventory.");
         System.out.println(" ");
         
        ArrayList<Products> productList = getStoreProducts();

            for(Products p : productList){

                 System.out.println( "We have " + p.getQuantity() + " of " + p.getName() + " which costs " + p.getPrice());
            }
    }
   
    public void whichItem(){
            System.out.println("Which item would you like to purchase?");
            System.out.println("\t 1. Books");
            System.out.println("\t 2. CDs");
            System.out.println("\t 3. DVDs");
        }
    
    
    public void addBookOrder(int purchaseItem){
        if(purchaseItem == 1){
                double b1 = bookProducts.get(0).getPrice();
                totalPurchaseAmount = b1;
                bookProducts.remove(0);
                totalNumBooks--;
        }
        else if(purchaseItem == 2){
                double b2 = bookProducts.get(1).getPrice();
                totalPurchaseAmount = b2;
                bookProducts.remove(1);
                totalNumBooks--;
        }
        else if(purchaseItem == 3){
               double b3 = bookProducts.get(2).getPrice();
                totalPurchaseAmount = b3;
                bookProducts.remove(2);
                totalNumBooks--;
        }
        else if(purchaseItem == 4){
                double b4 = bookProducts.get(3).getPrice();
                totalPurchaseAmount = b4;
                bookProducts.remove(3);
                totalNumBooks--;
        }
        else{
             System.out.println("Error");
        }
        System.out.println("The cost for the product right now is " + totalPurchaseAmount);
        totalCost = totalPurchaseAmount + totalCost;       
    }
    
    
    public void addCDOrder(int purchaseItem){
        if(purchaseItem == 1){
                double c1 = cdProducts.get(0).getPrice();
                totalPurchaseAmount = c1;
                cdProducts.remove(0);
                totalNumCDs--;
        }
        else if(purchaseItem == 2){
                double c2 = cdProducts.get(1).getPrice();
                totalPurchaseAmount = c2;
                cdProducts.remove(1);
                totalNumCDs--;
        }
        else if(purchaseItem == 3){
               double c3 = cdProducts.get(2).getPrice();
                totalPurchaseAmount = c3;
                cdProducts.remove(2);
                totalNumCDs--;
        }
        else{
            System.out.println("Error");
        }
        System.out.println("The cost for the product right now is " + totalPurchaseAmount);
        totalCost = totalPurchaseAmount + totalCost;
    }
    
    public void addDVDOrder(int purchaseItem){
        if(purchaseItem == 1){
                double d1 = dvdProducts.get(0).getPrice();
                totalPurchaseAmount = d1;
                dvdProducts.remove(0);
                totalNumDVDs--;
     
        }
        else if(purchaseItem == 2){
                double d2 = dvdProducts.get(1).getPrice();
                totalPurchaseAmount = d2;
                dvdProducts.remove(1);
                totalNumDVDs--;
        }
        else if(purchaseItem == 3){
               double d3 = dvdProducts.get(2).getPrice();
                totalPurchaseAmount = d3;
                dvdProducts.remove(2);
                totalNumDVDs--;
        }
        else{
                System.out.println("Error");
        }
        System.out.println("The cost for the product right now is " + totalPurchaseAmount);
        totalCost = totalPurchaseAmount + totalCost;
    }
    
    public void purchaseItem(int whichItem){
        if(whichItem == 1){
           int num1 = 1;
           System.out.println("Please pick the product you would like to buy");

           ArrayList<Books> bookList = getBookProducts();
           for(Books i: bookList){
               System.out.println("\t " + num1 + ". " + i.getName() + i.getPrice());
               num1++;
            }
           
          int purchaseItem = sc.nextInt();

          addBookOrder(purchaseItem);
          System.out.println("Your total cost is " + totalCost);
        }

        else if(whichItem == 2){
           int num1 = 1;
           System.out.println("Please pick the product you would like to buy");

           ArrayList<CDs> cdList = getCDProducts();
           for(CDs i: cdList){
               System.out.println("\t " + num1 + ". " + i.getName() + i.getPrice());
               num1++;
          }

           int purchaseItem = sc.nextInt();

           addCDOrder(purchaseItem);
           System.out.println("Your total cost is " + totalCost);
       }

       else if(whichItem == 3){
           int num1 = 1;
           System.out.println("Please pick the product you would like to buy");

           ArrayList<DVDs> dvdList = getDVDProducts();
           for(DVDs i: dvdList){
               System.out.println("\t " + num1 + ". " + i.getName() + i.getPrice());
               num1++;
            }

           int purchaseItem = sc.nextInt();

           addDVDOrder(purchaseItem);
           System.out.println("Your total cost is " + totalCost);
        }

       else{
           System.out.println("Error, please run the program again and choose the numbers given.");
       }    
    }
    
    
    public void letsPurchaseItems(){
        System.out.println("Would you like to purchase our things? Type 'true' or type 'false'");
        boolean wannaPurchase = sc.nextBoolean();

        while(wannaPurchase == true){
            whichItem();
            int whichItem = sc.nextInt();
            purchaseItem(whichItem);
            System.out.println("Are you done shopping? Type 'true' or 'false'");

            boolean donePurchasing = sc.nextBoolean();

            if(donePurchasing == false){
               letsPurchaseItems();
            }
            else{
               break;
            }
            break;
        }

        System.out.println("Your total cost was " + totalCost);
        System.out.println("Thank you for shopping with us!");
    }

  
    public void returnItem(){      
       System.out.println("Why are you returning this item?");
       System.out.println("\t 1. The item is damaged or broken");
       System.out.println("\t 2. Other");

       int item = sc.nextInt();

       System.out.println("Please select one: ");
       System.out.println("\t 1. Books");
       System.out.println("\t 2. CDs");
       System.out.println("\t 3. DVDs");

        if(item == 1){
            System.out.println("You can't return the item if it's damaged or opened");
        }
        else if(item == 2){
        System.out.println("Enter which category of the item you are trying to return: ");
        int whichProduct = sc.nextInt();
        int num1 =1;
        if(whichProduct == 1){
               ArrayList<Books> bookList = getBookProducts();
               for(Books i: bookList){

                    System.out.println("\t " + num1 + ". " + i.getName() + i.getPrice());
                    num1++;
        }

        System.out.println("Which item are you returning?");
        int whichReturn = sc.nextInt();
         if(whichReturn == 1){
                bookProducts.add(bookProducts.get(0));
                
                totalNumBooks++;
            }
            else if(whichReturn == 2){
                bookProducts.add(bookProducts.get(1));
                totalNumBooks++;
            }
            else if(whichReturn == 3){
                bookProducts.add(bookProducts.get(2));
                totalNumBooks++;
            }
            else if(whichReturn == 4){
                bookProducts.add(bookProducts.get(3));
                totalNumBooks++;
            }                
        }
        else if(whichProduct == 2){
           ArrayList<CDs> cdList = getCDProducts();
           for(CDs i: cdList){

                System.out.println("\t " + num1 + ". " + i.getName() + i.getPrice());
                num1++;
           }
           System.out.println("Which item are you returning?");
           int whichReturn = sc.nextInt();

            if(whichReturn == 1){
                    cdProducts.add(cdProducts.get(0));
                    totalNumCDs++;
            }
            else if(whichReturn == 2){
                cdProducts.add(cdProducts.get(1));
                totalNumCDs++;
            }
            else if(whichReturn == 3){
                cdProducts.add(cdProducts.get(2));
                totalNumCDs++;
            }
        }                    
        else if(whichProduct == 3){
           ArrayList<DVDs> dvdList = getDVDProducts();
           for(DVDs i: dvdList){
            System.out.println("\t " + num1 + ". " + i.getName() + i.getPrice());
            num1++;
           } 
            System.out.println("Which item are you returning?");
            int whichReturn = sc.nextInt();

            if(whichReturn == 1){
            dvdProducts.add(dvdProducts.get(0));
            totalNumDVDs++;
            }
            else if(whichReturn == 2){
                dvdProducts.add(dvdProducts.get(1));
                totalNumDVDs++;
            }
            else if(whichReturn == 3){
                dvdProducts.add(dvdProducts.get(2));
                totalNumDVDs++;
            }
        }
      }
    }
    

    public void addRegularMember(String mem, double spent){
        Membership newRegMem = new Membership(mem, spent);
        regular.add(newRegMem);
        /*incrementNextRegMemNum();
        newRegMem.getMemberNumber();*/
    }
    
    public void ifNotPaid(boolean paidOrNot){
        if(paidOrNot == false){
            System.out.println("Since you haven't paid the fee yet, you have to do that first.");
            totalCost = totalCost + 15;
            System.out.println("Your fee was added to your total cost. Your total cost is " + totalCost);
        }
//        else{
//            System.out.println("Ok, thank you for paying it!");
//        }
    }
    
    public void addPremiumMember(String mem, double spent, boolean paidOrNot){
        PremiumMemberships newPremMem = new PremiumMemberships(mem, spent, paidOrNot);
        premium.add(newPremMem);
    }
    
    public void joinAMembership(){
        System.out.println("Do you want to be a member?");
        System.out.println("\t 1. Yes");
        System.out.println("\t 2. No, thank you");

        int memberOrNot = sc.nextInt();

        if(memberOrNot == 1){
            System.out.println("Which membership do you want? Regular: free, or premium: $15 fee per month");
            System.out.println("\t 1. Regular");
            System.out.println("\t 2. Premium");

            int whichMembership = sc.nextInt();

            if(whichMembership == 1){

                System.out.println("What is your name?");
                String mem = sc.next();
                double spent = totalCost;


                addRegularMember(mem, spent);
                System.out.println("Thank you " + mem  + ". The total money you spent was " + spent);
                System.out.println("Welcome to being our new regular member!");
            }
            else if(whichMembership == 2){
                System.out.println("What is your name?");
                String mem = sc.next();

                double spent = totalCost;

                System.out.println("Did you pay your monthly fee yet? Type 'true' for yes and 'false' for no");
                boolean paidOrNot = sc.nextBoolean();

                addPremiumMember(mem, spent, paidOrNot);

                if(paidOrNot == false){
                ifNotPaid(paidOrNot);
                spent = totalCost;
                }
                else{
                    System.out.println("Thank You!");
                    spent = totalCost;
                }

                System.out.println("Thank you " + mem + ", The total money you spent was " + spent + ". For have you paid or not, you said " + paidOrNot + ". So if you picked no, we have added the monthly fee of $15 on your total spent, and if you clicked yes, then thanks for already paying!");
                System.out.println("Welcome to being our new premium member!");

            }
                   
        }
    }
    
    public void displayRegMembers(){
        for(Membership reg: regular){
            System.out.println("Member name: " + reg.getMemberName() + ", Total Spent: " + reg.getTotalSpent());
        }
    }
    
    public void displayPremMembers(){
        for(PremiumMemberships prem: premium){
            System.out.println("Member name: " + prem.getMemberName() + ", Total Spent: " + prem.getTotalSpent() + ", Fee Paid or Not: " + prem.ispaidOrNot());
        }
    }
   
}

