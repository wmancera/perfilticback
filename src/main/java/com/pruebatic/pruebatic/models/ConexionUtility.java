/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebatic.pruebatic.models;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author William
 */
public class ConexionUtility {
	
	// DRIVER DE JDBC Y URL
	static final String JDBC_DRIVER = "org.postgresql.Driver";  
	static final String DB_URL = "jdbc:postgresql://localhost:5432/BD_APP";

	// CREDENCIALES DE USUARIO
	static final String USUARIO = "postgres";
	static final String CONTRASENA = "admin";
	
	public static Connection getConexion(){
		Connection connection = null;
		try {
			// CARGAR CLASES DEL DRIVER EN MEMORIA
			Class.forName(JDBC_DRIVER);

			// ESTABLECE CONEXION
			connection = DriverManager.getConnection(DB_URL, USUARIO, CONTRASENA);
			
		} catch(SQLException se){
			//Manejo de errores para JDBC
			System.err.println("En Excepcion de JDBC");
			se.printStackTrace();
		} catch(Exception e){
		    //Manejo de errores para Class.forName
			System.err.println("En Excepcion de Class.forName");
		    e.printStackTrace();
		} finally {
			return connection;
		}
	}
	
	
	/*
	 * En los sucesivos métodos se evita NullPointerException 
	 * para que no pise la Exception que me interesa detectar. 
	 */

	
	public static void cerrarConexion(Connection connection){
		if (connection != null){ 
			try {connection.close();} 
			catch (SQLException e) {e.printStackTrace();}
		}
	}
	
    public static void cancelarCommit(Connection c) {
    	if (c != null) {
            try{c.rollback();}
            catch (SQLException e){e.printStackTrace();}
    	}
    }
	
	public static void cerrarRset(ResultSet rset){
		if (rset != null){ 
			try {rset.close();} 
			catch (SQLException e) {e.printStackTrace();}
		}
	}
	
	public static void cerrarStmt(Statement stmt){
		if (stmt != null){ 
			try {stmt.close();} 
			catch (SQLException e) {e.printStackTrace();}
		}
	}
	
	public static void cerrarCst(CallableStatement cst){
		if (cst != null){ 
			try {cst.close();} 
			catch (SQLException e) {e.printStackTrace();}
		}
	}
	
	
	public static void cerrarPreparedStmt(PreparedStatement pst){
		if (pst != null){ 
			try {pst.close();} 
			catch (SQLException e) {e.printStackTrace();}
		}
	}

}

