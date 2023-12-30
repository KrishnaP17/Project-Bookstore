/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patelkrishnaaproject1;

/**
 *
 * @author krp17
 */
public class Membership {
    
    private String member;
    private double totalSpent;
    
    public Membership(String mem, double spent){
        this.member = mem;
        this.totalSpent = spent;
        //this.memberNumber = memNum;
    }
    
    public String getMemberName(){
        return this.member;
        
    }
    
    public double getTotalSpent(){
        return this.totalSpent;
    }
    
    public void setMemberName(String mem){
    this.member = mem;
    }
    
    public void setTotalSpent(double spent){
        this.totalSpent = spent;
    }
      
}
