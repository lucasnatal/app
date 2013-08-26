/**
 * 
 */
package com.natal.utils;

/**
 * @author Lucas Natal
 */
public class Game {
	
	private int id;
	
	private String nome;
	
	private Fabricante fabricante;
	
	private boolean isServerBr;
	
	
	public Game(String nome, Fabricante fabricante, boolean isServerBr) {
		this.nome = nome;
		this.fabricante = fabricante;
		this.isServerBr = isServerBr;
	}
	
	public Game(int id, String nome, Fabricante fabricante, boolean isServerBr) {
		this(nome, fabricante, isServerBr);
		this.id = id;
	}
	
	public Game(){
		
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public boolean isServerBr() {
		return isServerBr;
	}

	public void setServerBr(boolean isServerBr) {
		this.isServerBr = isServerBr;
	}

}
