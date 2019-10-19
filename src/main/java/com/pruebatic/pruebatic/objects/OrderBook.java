/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebatic.pruebatic.objects;

import java.io.Serializable;

/**
 *
 * @author William
 */
public class OrderBook implements Serializable{
    private int idOrder;
    private int quantity;
    private int cost;
    /**
     * @return the idOrder
     */
    public int getIdOrder() {
        return idOrder;
    }

    /**
     * @param idOrder the idOrder to set
     */
    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
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

}
