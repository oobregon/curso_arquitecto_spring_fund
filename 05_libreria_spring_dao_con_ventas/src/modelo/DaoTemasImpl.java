/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javabeans.Tema;

/**
 *
 * @author Profesortarde
 */
@Repository (value = "daoTemasImplUno")
 public class DaoTemasImpl implements DaoTemas { 
	@Autowired
	JdbcTemplate accDatos;
	
    @Override
	public List<Tema> obtenerTemas() {
    	String sql="select * from temas";
    	return accDatos.query(sql,(rs,fila) -> new Tema(rs.getInt("idTema"),rs.getString("tema")));    	
    }
}
