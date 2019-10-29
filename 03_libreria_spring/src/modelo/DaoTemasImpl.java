/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javabeans.Tema;

/**
 *
 * @author Profesortarde
 */
@Repository (value = "daoTemasImplUno")
 public class DaoTemasImpl implements DaoTemas {
	 @Autowired
	 @Qualifier ("dsServidor")
	 DataSource ds;
	
    @Override
	public List<Tema> obtenerTemas(){
        List<Tema> lista=new ArrayList<> ();
           
        try(Connection cn = ds.getConnection();) {                       
            //Paso 2: Envio SQL
            String sql="select * from temas";
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);            
            while(rs.next()){
                lista.add(new Tema(rs.getInt("idTema"),rs.getString("tema")));
            }
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }   
        return lista;
    }
}
