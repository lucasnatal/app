/**
 * 
 */
package com.natal.beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.natal.dao.FabricanteDao;
import com.natal.utils.Fabricante;

/**
 * @author Lucas Natal
 */
public class CadastroFabricanteMB {

	private List<Fabricante> fabricantes;

	private List<Fabricante> fabricantesExclui;

	private Fabricante fabricante;

	private Fabricante fabricanteSelecionado;

	private FabricanteDao fd;

	public CadastroFabricanteMB() {

		this.fabricantes = new ArrayList<Fabricante>();
		this.fabricantesExclui = new ArrayList<Fabricante>();

		try {
			this.fd = new FabricanteDao();
			this.fabricantes = this.fd.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		this.fabricanteSelecionado = new Fabricante();
		this.fabricante = new Fabricante();
	}

	public void gravar() {
		try {
			this.fd.inserir(fabricante);
			fabricantes = fd.selectAll();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		fabricante = new Fabricante();

	}

	public void excluir() {
		
		//if (montarListaExclusao()) {
		if (fabricantesExclui.size() > 0) {
			try {
				this.fd.deleteDynamic(this.fabricantesExclui);
				this.fabricantes = this.fd.selectAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			this.fabricantesExclui = new ArrayList<Fabricante>();
		}
	}

	public List<Fabricante> getFabricantesExclui() {
		return fabricantesExclui;
	}

	public void setFabricantesExclui(List<Fabricante> fabricantesExclui) {
		this.fabricantesExclui = fabricantesExclui;
	}

	private boolean montarListaExclusao() {
	
		boolean result = false;
		
		for (Fabricante f : fabricantes) {
			
			if (f.isSelected()){
				
				fabricantesExclui.add(f);
				result = true;		
			}	
		}
		
		return result;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public Fabricante getFabricanteSelecionado() {
		return fabricanteSelecionado;
	}

	public void setFabricanteSelecionado(Fabricante fabricanteSelecionado) {
		this.fabricanteSelecionado = fabricanteSelecionado;
	}

}
