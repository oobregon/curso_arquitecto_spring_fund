/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javabeans.Libro;

/**
 *
 * @author Profesortarde
 */
@Repository (value = "daoLibImplUno")
 public class DaoLibrosImpl implements DaoLibros {
	@Autowired 
	@Qualifier ("dsServidor")
	DataSource ds;
		
    @Override
	public List<Libro> recuperarLibros(){
    	List<Libro> lista=new ArrayList<> ();
        try(Connection cn = ds.getConnection();) {                       
        	String sql="select * from libros";
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);            
            while(rs.next()){
                lista.add(new Libro(rs.getInt("isbn"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getDouble("precio"),
                        rs.getInt("paginas"),
                        rs.getInt("idTema")));
            }
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }   
        return lista; 
    }
    
    @Override
	public List<Libro> recuperarLibros(int idTema){
    	List<Libro> lista=new ArrayList<> ();
        try(Connection cn = ds.getConnection();) {                       
        	String sql="select * from libros where idTema=?";
            PreparedStatement st=cn.prepareStatement(sql);
            st.setInt(1, idTema);
            ResultSet rs=st.executeQuery();            
            while(rs.next()){
                lista.add(new Libro(rs.getInt("isbn"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getDouble("precio"),
                        rs.getInt("paginas"),
                        rs.getInt("idTema")));
            }
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }   
        return lista; 
    }       
}
