/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testptic.testptic.controller;

import com.pruebatic.pruebatic.models.BookModel;
import com.pruebatic.pruebatic.objects.Article;
import com.pruebatic.pruebatic.objects.Book;
import com.pruebatic.pruebatic.objects.OrderBook;
import com.pruebatic.pruebatic.objects.OrderBookDetail;
import java.util.ArrayList;

/**
 *
 * @author William
 */
public class BookController {
    public String getBooks(){
        BookModel bm =  new BookModel();
        String htmlCode = "";
        for(Book b : bm.getAllBooks()){
            htmlCode += "<div class=\"col-sm-4\">\n" +
"							<div class=\"product-image-wrapper\">\n" +
"								<div class=\"single-products\">\n" +
"									<div class=\"productinfo text-center\">\n" +
"										<img src=\""+b.getImage()+"\" alt=\"\" />\n" +
"										<h2>$"+b.getCost()+"</h2>\n" +
"										<p>"+b.getDescription()+"</p>\n" +
"										<a href=\"book-details.jsp?id="+b.getId()+"\" class=\"btn btn-default add-to-cart\"><i class=\"fa fa-shopping-cart\"></i>Ver Detalles</a>\n" +
"									</div>\n" +
"									<div class=\"product-overlay\">\n" +
"										<div class=\"overlay-content\">\n" +
"											<h2>$"+b.getCost()+"</h2>\n" +
"											<p>"+b.getDescription()+"</p>\n" +
"										<a href=\"book-details.jsp?id="+b.getId()+"\" class=\"btn btn-default add-to-cart\"><i class=\"fa fa-shopping-cart\"></i>Ver Detalles</a>\n" +
"										</div>\n" +
"									</div>\n" +
"								</div>\n" +
"								<div class=\"choose\">\n" +
"									<ul class=\"nav nav-pills nav-justified\">\n" +
"										<li><a href=\"\"><i class=\"fa fa-plus-square\"></i>Add to wishlist</a></li>\n" +
"										<li><a href=\"\"><i class=\"fa fa-plus-square\"></i>Add to compare</a></li>\n" +
"									</ul>\n" +
"								</div>\n" +
"							</div>\n" +
"						</div>";
        }       
        return htmlCode;
    }
    
    public Book getBook(int id){
        return new BookModel().getBookId(id);
    }
    
    /**
     * Method to save data of articles with their quantitys
     * @param articles
     * @return 
     */
    public String saveOrder(ArrayList<Article> articles){
        BookModel bm = new BookModel();
        OrderBook orderBook = new OrderBook();
        
        orderBook.setCost(0);
            for(Article a : articles){
                Book book = new Book();
                book.setId(a.getIdArticle());
                book.setQuantity(a.getCantidad());
                orderBook.setQuantity(a.getQuantityOrder());
                String resUpd = bm.updateQuantity(book, orderBook.getQuantity());
                if(!"OK".equals(resUpd)){
                    return "error::"+resUpd;
                }
            }
        return bm.saveOrder(orderBook);
    }
}
