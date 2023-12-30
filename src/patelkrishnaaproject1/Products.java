/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patelkrishnaaproject1;

/**
 *
 * @author krp17
 */
 public abstract class Products implements Comparable<Products>{
 
    private String itemName;
    private double itemPrice;
    private int productID;
    private int quantity;
    
    
    public Products(String name, double price, int ID, int quantity ){
        this.itemName = name;
        this.itemPrice = price;
        this.productID = ID;
        this.quantity = quantity;
    }
    public String getName(){
        return itemName;
    }
    
    public double getPrice(){
        return itemPrice;
    } 
    
    public void setName(String name){
        this.itemName = name;
    }
    
    public void setPrice(double price){
        this.itemPrice = price;
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
    public int getQuantity(){
        return this.quantity;
    }
    
    public void setProductID(int ID){
        this.productID = ID;
    }
    
    public int getProductID(){
        return this.productID;
    }
    
    @Override
    public int compareTo(Products o){
        if(this.getPrice() > o.getPrice()){
            return 1;
        }
        if(this.getPrice() < o.getPrice()){
            return -1;
        }
        return 0;
    }
}
