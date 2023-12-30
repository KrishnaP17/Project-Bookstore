/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patelkrishnaaproject1;

/**
 *
 * @author krp17
 */
public class PremiumMemberships extends Membership {
    //private String member;
    //private double totalSpent;
    private boolean feePaid;
    
    private int fee = 15;
    
    public PremiumMemberships(String mem, double spent, boolean paidOrNot){
        super(mem, spent);
        this.feePaid = paidOrNot;
    }
    
    public boolean ispaidOrNot(){
        return this.feePaid;
    }  
}
