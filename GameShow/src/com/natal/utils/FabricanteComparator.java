/**
 * 
 */
package com.natal.utils;

import java.util.Comparator;

/**
 * @author Lucas Natal
 */
public class FabricanteComparator implements Comparator<Fabricante>{

	private boolean asc;
	
	private final int SORT_NOME = 1;
	private final int SORT_ORIGEM = 2;
	
	
	public FabricanteComparator() {
	
	}
	
	public FabricanteComparator(boolean asc) {
		this.asc = asc;
	}
	
	public int getSORT_NOME() {
		return SORT_NOME;
	}

	public int getSORT_ORIGEM() {
		return SORT_ORIGEM;
	}
	
	public boolean isAsc() {
		return asc;
	}

	public void setAsc(boolean asc) {
		this.asc = asc;
	}

	public int compare(Fabricante fab1, Fabricante fab2) {
		if (asc)
			return fab1.getNome().toLowerCase().compareTo(fab2.getNome().toLowerCase());
		return fab2.getNome().toLowerCase().compareTo(fab1.getNome().toLowerCase());
	}
	
}
