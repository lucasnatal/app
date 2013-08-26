package com.natal.beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.natal.dao.FabricanteDao;
import com.natal.utils.Fabricante;
import com.natal.utils.FabricanteComparator;

/**
 * 
 * @author Lucas Natal
 */

public class FabricanteMB {

	private List<Fabricante> lista;
	private List<Fabricante> selecionados;
	private List<Fabricante> listaFiltrados;

	private Fabricante selectedItem;
	
	private FabricanteComparator fc;

	private boolean checkAll;
	private boolean sorted;
	private boolean asc;

	private String filter;
	
	private Integer ordenadoPor;

	public FabricanteMB() {
		
		this.fc = new FabricanteComparator();
		try {
			this.lista = new FabricanteDao().selectAll();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}


	
	public List<Fabricante> getLista() {
		return lista;
	}

	public void setLista(List<Fabricante> lista) {
		this.lista = lista;
	}

	public List<Fabricante> getSelecionados() {
		return selecionados;
	}

	public void setSelecionados(List<Fabricante> selecionados) {
		this.selecionados = selecionados;
	}


	public boolean isCheckAll() {
		return checkAll;
	}


	public void setCheckAll(boolean checkAll) {
		this.checkAll = checkAll;
	}



	public boolean isAsc() {
		return asc;
	}


	public void setAsc(boolean asc) {
		this.asc = asc;
	}


	public boolean isSorted() {
		return sorted;
	}


	public void setSorted(boolean sorted) {
		this.sorted = sorted;
	}

	public Fabricante getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(Fabricante selectedItem) {
		this.selectedItem = selectedItem;
	}

	
	public String getFilter() {
		return filter;
	}



	public void setFilter(String filter) {
		this.filter = filter;
	}



	public List<Fabricante> getListaFiltrados() {
		return listaFiltrados;
	}



	public void setListaFiltrados(List<Fabricante> listaFiltrados) {
		this.listaFiltrados = listaFiltrados;
	}
	
	
	/**/
	public void sort(){
		
		this.sorted = true;
		this.setAsc(!this.asc);
		
		this.fc.setAsc(this.asc);
		
		if (this.filter != null && this.filter.length() > 0)
			Collections.sort(this.listaFiltrados, this.fc);
		else
			Collections.sort(this.lista, this.fc);
		
	}
	
	public void excluir(){
		try{
			new FabricanteDao().delete(this.selectedItem);
		}catch(SQLException s){
			
		}
	}
	
	public void marcarTodos(){

		for (int i = 0; i < this.lista.size(); i++) {
			this.lista.get(i).setSelected(this.checkAll);
		}

	}
	
	public void search(){
		
		this.listaFiltrados = new ArrayList<>();
		
		for (int i = 0; i < this.lista.size(); i++) {
			
			if(lista.get(i).getNome().toLowerCase().contains(this.filter.toLowerCase()))
				
				this.listaFiltrados.add(lista.get(i));
		}
			
		
	}



	public FabricanteComparator getFc() {
		return fc;
	}



	public Integer getOrdenadoPor() {
		return ordenadoPor;
	}



	public void setOrdenadoPor(Integer ordenadoPor) {
		this.ordenadoPor = ordenadoPor;
	}



}
