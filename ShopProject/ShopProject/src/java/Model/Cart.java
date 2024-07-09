/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class Cart {
    List<Item> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public Cart(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
     
    private Item getItemById(int id){
        for (Item i : items) {
            if(i.getProduct().getProductId() == id){
                return i;
            }            
        }
        return null;
    }
    
    public int getQuantityById(int id) {
        return  getItemById(id).getQuantity();
    }
    //add cart
    public void addItem(Item t) {
        if(getItemById(t.getProduct().getProductId()) != null){
            Item i = getItemById(t.getProduct().getProductId());
            i.setQuantity(i.getQuantity() + t.getQuantity());
        }else{
            items.add(t);
        }
    }
    
    public void removeItem(int id){
        if(getItemById(id) != null){
            items.remove(getItemById(id));
        }
    }
    
    public double getTotalMoney() {
        double m = 0;
        for (Item i : items) {
            m+= i.getQuantity()*i.getPrice(); 
        }
        return m;
    }
    
}
