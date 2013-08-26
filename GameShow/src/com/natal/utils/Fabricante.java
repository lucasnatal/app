/**
 * 
 */
package com.natal.utils;

/**
 * @author Lucas Natal
 */
public class Fabricante {
	
	private int id;
	
	private String nome;
	
	private String origem;
	
	private boolean indie;
	
	/*Usado para excluir quando for verdadeiro*/
	private boolean selected;
	
	
	public Fabricante(String nome, String origem, boolean indie) {
		this.nome = nome;
		this.origem = origem;
		this.indie = indie;
	}
	
	public Fabricante(int id, String nome, String origem, boolean indie) {
		this(nome, origem, indie);
		this.id = id;
	}
	
	public Fabricante() {
	
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

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public boolean getIndie() {
		return indie;
	}

	public void setIndie(boolean indie) {
		this.indie = indie;
	}

	public boolean isSelected() {
		return this.selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}
