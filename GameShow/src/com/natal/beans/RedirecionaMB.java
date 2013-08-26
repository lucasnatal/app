/**
 * 
 */
package com.natal.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucas Natal
 */
public class RedirecionaMB {
	
	/*P�gina a ser redirecionada*/
	private String paginaSelecionada;
	
	/*Pilha de p�ginas*/
	private List<String> pilhaPaginas;
	
	/*Index atual da lista*/
	private int indexAtual;
	
	/*P�gina padr�o. 
	 * Erros de direcionamento resultar�o na chamada da p�gina padr�o.*/
	private final String PAGINA_PADRAO = "Index";
	
	/*Modo como o link da p�gina vai ser visto pelo usu�rio*/
	private final String FACES_REDIRECT = "?faces-redirect=true";
		
	
	public RedirecionaMB() {
		
		this.indexAtual = -1;
		this.pilhaPaginas = new ArrayList<String>(); 
	}

	public String redirecionar(){
		
		this.indexAtual++;
		this.pilhaPaginas.add(this.paginaSelecionada);
		return this.paginaSelecionada + this.FACES_REDIRECT;
		
	}
	
	public String voltar(){

		if (this.pilhaPaginas.size() > 0) {
			
			this.pilhaPaginas.remove(indexAtual);
			this.indexAtual--;
			this.paginaSelecionada = pilhaPaginas.get(indexAtual) ;
			return this.paginaSelecionada + this.FACES_REDIRECT;
		
		}else{
			
			this.pilhaPaginas = new ArrayList<String>();
			this.indexAtual = 0;
			this.pilhaPaginas.add(this.PAGINA_PADRAO);
			return this.PAGINA_PADRAO + this.FACES_REDIRECT;
		}
	}
	
	public String getPaginaSelecionada() {
		return paginaSelecionada;
	}


	public void setPaginaSelecionada(String paginaSelecionada) {
		this.paginaSelecionada = paginaSelecionada;
	}

	
}
