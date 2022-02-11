/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dataBase.DriverDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Documento;
import modelo.Genero;
import modelo.Usuario;

/**
 *
 * @author sebastian piza
 */
public class UsuarioDao {
    private final Connection connection;
    
    public UsuarioDao(){
        this.connection = DriverDB.getConnection();
    }
     public Usuario login(String nombreUsuario, String clave) {
        System.out.println(nombreUsuario + " -- " + clave);
        Usuario u = null;

        String consulta = "select * from usuario u\n" +
                "inner join persona p\n" +
                "on u.PersonaId = p.id\n" +
                "where u.nombreUsuario = ? and u.clave = ?;";
        PreparedStatement statement = null;

        try {

            statement = connection.prepareStatement(consulta);
            statement.setString(1, nombreUsuario);
            statement.setString(2, clave);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                int id = result.getInt("id");
                int idPersona = result.getInt("PersonaId");
                String pimerNombre = result.getString("primerNombre");
                String segundoNombre = result.getString("SegundoNombre");
                String primerApellido = result.getString("PrimerApellido");
                String segundoApellido = result.getString("SegundoApellido");
                int documentoId = result.getInt("idDocumento");
                String numeroDocumento = result.getString("NumeroDocumento");
                int generoId = result.getInt("generoId");
                String correo = result.getString("correo");
                
                u = new Usuario(id, idPersona);

                u.setPrimerNombre(pimerNombre);
                u.setSegundoNombre(segundoNombre);
                u.setPrimerApellido(primerApellido);
                u.setSegundoApellido(segundoApellido);
                u.setNombreUsuario(u.getNombreUsuario());
                u.setDocumento(new Documento(documentoId));
                u.setNumeroDocumento(numeroDocumento);
                u.setGenero(new Genero(generoId));
                u.setCorreo(correo);
                
                
            }
        }catch (Exception ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return u;
        
     }    
}
