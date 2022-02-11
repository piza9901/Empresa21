/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dataBase.DriverDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Persona;

/**
 *
 * @author sebastian piza
 */
public class PersonaDao {
    private final Connection connection;
    
    public PersonaDao(){
        this.connection = DriverDB.getConnection();
    }
    
    public boolean eliminarPersona(Persona p) {
        String consulta = "delete from persona where id = ?; ";
        PreparedStatement st = null;
        
        try{
            st = connection.prepareStatement(consulta);
            st.setInt(1, p.getIdPersona());
            
            st.execute();
            
            return true;
        }catch (Exception ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
