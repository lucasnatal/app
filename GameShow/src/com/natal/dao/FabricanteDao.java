/**
 * 
 */
package com.natal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.natal.utils.Fabricante;

/**
 * @author Lucas Natal
 */
public class FabricanteDao extends Dao {

	public FabricanteDao(){
		
		super();
	}
	
	public void inserir(Fabricante f) throws SQLException{
		
		
		PreparedStatement ps = c.prepareStatement("insert into fabricantes (nome, pais_origem, indie) values (?, ?, ?)");
		ps.setString(1, f.getNome());
		ps.setString(2, f.getOrigem());
		ps.setBoolean(3, f.getIndie());
		ps.addBatch();
		ps.executeBatch();
		
	}
	
	public ArrayList<Fabricante> selectAll() throws SQLException{
		
		ArrayList<Fabricante> listaFabricante = new ArrayList<Fabricante>();
		
		PreparedStatement ps = c.prepareStatement("select * from fabricantes");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			listaFabricante.add(new Fabricante(rs.getInt("id_fabricante"), rs.getString("nome"), rs.getString("pais_origem"), rs.getBoolean("indie")));
		}
		
		return listaFabricante;
	}
	
	public void delete(Fabricante f) throws SQLException{
		
		PreparedStatement ps = c.prepareStatement("delete from fabricantes where id_fabricante = ?");
		
		ps.setInt(1, f.getId());
		ps.addBatch();
		ps.executeBatch();
		
	}
	
	public void deleteDynamic(List<Fabricante> fabricantes) throws SQLException{
		
		StringBuilder sqlFabricantesDeletar = new StringBuilder();
		sqlFabricantesDeletar.append("delete from fabricantes where ");
		
		int i = 0;
		for (Fabricante fabricante : fabricantes) {
			if (i == 0)
				sqlFabricantesDeletar.append(" id_fabricante = " + fabricante.getId());
			else
				sqlFabricantesDeletar.append(" or id_fabricante = " + fabricante.getId());
			i++;
		}
		System.out.println(sqlFabricantesDeletar);
		PreparedStatement ps = c.prepareStatement(sqlFabricantesDeletar.toString());
		ps.executeUpdate();
		
	}
}
