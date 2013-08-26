/**
 * 
 */
package com.natal.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Lucas Natal
 */
public class ConnectionFactory {
	
	protected Connection c;
	
	public ConnectionFactory(){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/games", "root", "");
		}catch(Exception e){
			System.err.println("Erro ao conectar com o banco de dados.");
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		return this.c;
	}
	
	public void closeConnection(){
		try{
			this.c.close();
		}catch(SQLException e){
			System.err.println("Erro ao finalizar a conexão com o banco de dados.");
			e.printStackTrace();
		}
	}

}
