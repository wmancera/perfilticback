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
public class Article {
    private int idArticle;
    private int cantidad;
    private int quantityOrder;
    
    public Article (int idArticle,int cantidad){
        this.idArticle=idArticle;
        this.cantidad=cantidad;
    }

    /**
     * @return the idArticle
     */
    public int getIdArticle() {
        return idArticle;
    }

    /**
     * @param idArticle the idArticle to set
     */
    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the quantityOrder
     */
    public int getQuantityOrder() {
        return quantityOrder;
    }

    /**
     * @param quantityOrder the quantityOrder to set
     */
    public void setQuantityOrder(int quantityOrder) {
        this.quantityOrder = quantityOrder;
    }

    
}
