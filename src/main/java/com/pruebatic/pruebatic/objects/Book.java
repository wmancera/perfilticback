/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebatic.pruebatic.objects;

/**
 *
 * @author William
 */
public class Book {
    
    private int id;
    private String description;
    private int quantity;
    private String image;
    private int cost;
    
    public Book(int id, String description, int quantity, String image, int cost){
        this.id=id;
        this.description= description;
        this.quantity=quantity;
        this.image=image;
        this.cost=cost;
    }
    
    public Book(int id){
        this.id=id;
    }
    
    public Book(){
        
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the cost
     */
    public int getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getAvailable(){
        if(quantity==0){
            return "Agotado";
        }else{
            return String.valueOf(this.getQuantity());
        }
    }
}
