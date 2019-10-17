/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebatic.pruebatic.models;

import com.pruebatic.pruebatic.objects.Book;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author William
 */
public class BookModel extends ConexionUtility{
    
    public ArrayList<Book> getAllBooks(){
        ArrayList<Book> libros =  new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet res = null;
        try{
            String sql = "select id_book, description,quantity,image,cost from book";
            pst = getConexion().prepareCall(sql);
            res = pst.executeQuery();
            while(res.next()){
                libros.add(new Book(res.getInt("id_book"),res.getString("description"),res.getInt("quantity"),res.getString("image"),res.getInt("cost")));
            }
        }catch(SQLException e){
            System.out.println("BookModel::getAllBooks::"+e.getMessage());
        }catch(Exception e){
            System.out.println("BookModel::getAllBooks::"+e.getMessage());
        } finally {
            try{
                if(res!=null) res.close();
                if(pst != null)pst.close();
                if(getConexion()!=null) getConexion().close();
            }catch(SQLException e){
                System.out.println("BookModel::getAllBooks::"+e.getMessage());
            }catch(Exception e){
                System.out.println("BookModel::getAllBooks::"+e.getMessage());
            }
        }
        return libros;
    }
    
    public Book getBookId(int id){
        Book libro = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        try{
            String sql = "select id_book,description,quantity,image,cost from book where id_book = ? ";
            pst = getConexion().prepareCall(sql);
            pst.setInt(1, id);
            res = pst.executeQuery();
            while(res.next()){
                libro =  new Book(res.getInt("id_book"),res.getString("description"),res.getInt("quantity"),res.getString("image"),res.getInt("cost"));
            }
        }catch(SQLException e){
            System.out.println("BookModel::getBookId::"+e.getMessage());
        }catch(Exception e){
            System.out.println("BookModel::getBookId::"+e.getMessage());
        } finally {
            try{
                if(res!=null) res.close();
                if(pst != null)pst.close();
                if(getConexion()!=null) getConexion().close();
            }catch(SQLException e){
                System.out.println("BookModel::getLibroId::"+e.getMessage());
            }catch(Exception e){
                System.out.println("BookModel::getLibroId::"+e.getMessage());
        }
        }
        return libro;
    }

}
