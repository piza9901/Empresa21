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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;
import modelo.Documento;
import modelo.Genero;

/**
 *
 * @author sebastian piza
 */
public class ClienteDao {
    private final Connection connection;
    
    public ClienteDao(){
        this.connection = DriverDB.getConnection();
    }
     public Cliente registrarCliente(Cliente cliente) {
     
        System.out.println("hello man 1");

        String consulta = "insert into persona (PrimerNombre, SegundoNombre, PrimerApellido, SegundoApellido, idDocumento, NumeroDocumento, generoId) \n" +
            "values (?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement statement = null;
        
        try {
            System.out.println("hello man 2");
            statement = connection.prepareStatement(consulta);
            statement.setString(1, cliente.getPrimerNombre());
            statement.setString(2, cliente.getSegundoNombre());
            statement.setString(3, cliente.getPrimerApellido());
            statement.setString(4, cliente.getSegundoApellido());
            statement.setInt(5, cliente.getDocumento().getId());
            statement.setString(6, cliente.getNumeroDocumento());
            statement.setInt(7, cliente.getGenero().getId());
            statement.execute();
            
        PreparedStatement stment = connection.prepareStatement("SELECT id AS LastID FROM persona where id = @@Identity;");
        stment.execute();
        
            ResultSet resultado = stment.getResultSet();
            
            if(resultado.next()){
                int personaId = resultado.getInt("LastID");
                System.out.println("hello man 3: " + personaId);
                
                PreparedStatement st = connection.prepareStatement("insert into cliente (correo, nombreUsuario, direccion, telefono, clave, PersonaId) \n" +
                "values (?, ?, ?, ?, ?, ?);");
                
                System.out.println("hello man 4: " + personaId);
                st.setString(1, cliente.getCorreo());
                st.setString(2, cliente.getNombreUsuario());
                st.setString(3, cliente.getDireccion());
                st.setString(4, cliente.getTelefono());
                st.setString(5, cliente.getClave());
                st.setInt(6, personaId);
                System.out.println("hello man 5: " + cliente.getIdPersona());
                st.execute();
             
                PreparedStatement stt = connection.prepareStatement("SELECT id AS LastID FROM cliente where id = @@Identity;");
                stt.execute();
                
                 ResultSet r = stt.getResultSet();
                 
                 if(r.next()){
                    int clienteId = resultado.getInt("LastID");
                    System.out.println("hello man 6" + clienteId);
                    
                    cliente.setId(clienteId);
                    cliente.setIdPersona(personaId);
                    System.out.println("hello man 7" + personaId);
                    System.out.println("hello man 8" + clienteId);
                    return cliente;
                 }
            }
            
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cliente;
     }
     
     public boolean eliminarCliente(Cliente c) {
        String consulta = "delete from cliente where id = ?; ";
        PreparedStatement st = null;
        
        try{
            st = connection.prepareStatement(consulta);
            st.setInt(1, c.getId());
            
            st.execute();
            
            return true;
        }catch (Exception ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     
     public Cliente getCliente(int idCliente) {
         
         Cliente c = null;
         
         String consulta = "select * from cliente c\n"
                + "inner join persona p\n"
                + "on c.PersonaId = p.id\n"
                + "where c.id = ?;";
         PreparedStatement st = null;
         
         try{
             
             st = connection.prepareStatement(consulta);
             
             ResultSet result = st.executeQuery();
             
             if(result.next()) {
                 int personaId = result.getInt("PersonaId");
                 String primerNombre = result.getString("PrimerNombre");
                 String segundoNombre = result.getString("SegundoNombre");
                 String primerApellido = result.getString("PrimerApellido");
                 String segundoApellido = result.getString("SegundoNombre");
                 int documentoId = result.getInt("idDocumento");
                 String numeroDocuemnto = result.getString("NumeroDocumento");
                 int generoId = result.getInt("generoId");
                 String correo = result.getString("correo");
                 String nombreUsuario = result.getString("nombreUsuario");
                 String telefono = result.getString("telefono");
                 
                 c = new Cliente(idCliente, personaId);
                 
                 c.setPrimerNombre(primerNombre);
                 c.setSegundoNombre(segundoNombre);
                 c.setPrimerApellido(primerApellido);
                 c.setSegundoApellido(segundoApellido);
                 c.setDocumento(new Documento(documentoId));
                 c.setNumeroDocumento(numeroDocuemnto);
                 c.setGenero(new Genero(generoId));
                 c.setTelefono(telefono);
                 c.setCorreo(correo);
                 c.setNombreUsuario(nombreUsuario);
                }
               
         }catch (Exception ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         return c;
     }
     
     public ArrayList<Cliente> getClientes() {
         try{
            String consulta = "select * from cliente c\n"
                + "inner join persona p\n"
                + "on c.PersonaId = p.id\n"
                + "inner join genero g\n"
                + "on p.generoId = g.id\n"
                + "inner join documento d\n"
                + "on p.idDocumento = d.id\n;";
         PreparedStatement st = null;
         st = connection.prepareStatement(consulta);
         st.execute();
          ResultSet result = st.executeQuery();
          ArrayList<Cliente> clientes = new ArrayList<>();
          
          while(result.next()) {
            int idCliente = result.getInt("id");
            int idPersona = result.getInt("PersonaId");
            String primerNombre = result.getString("PrimerNombre");
            String segundoNombre = result.getString("SegundoNombre");
            String primerApellido = result.getString("PrimerApellido");
            String segundoApellido = result.getString("SegundoNombre");
            int documentoId = result.getInt("idDocumento");
            String numeroDocuemnto = result.getString("NumeroDocumento");
            int generoId = result.getInt("generoId");
            String nombreGenero = result.getString(17);
            String correo = result.getString("correo");
            String nombreUsuario = result.getString("nombreUsuario");
            String telefono = result.getString("telefono");
            
            Cliente c = new Cliente();
            c.setId(idCliente);
            c.setIdPersona(idPersona);
            c.setPrimerNombre(primerNombre);
            c.setSegundoNombre(segundoNombre);
            c.setPrimerApellido(primerApellido);
            c.setSegundoApellido(segundoApellido);
            c.setDocumento(new Documento(documentoId));
            c.setNumeroDocumento(numeroDocuemnto);
            c.setGenero(new Genero(generoId, nombreGenero));
            c.setTelefono(telefono);
            c.setCorreo(correo);
            c.setNombreUsuario(nombreUsuario);    
          }
          return clientes;
             
         }catch (Exception ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
     }
     
     public boolean editarCliente(Cliente cliente) {
        System.out.println("estamos jodidos y medio");
        try {
            PreparedStatement stmt = connection.prepareStatement("update persona set PrimerNombre = ?, SegundoNombre = ?, PrimerApellido = ?, SegundoApellido = ?, \n"
                    + "idDocumento = ?, NumeroDocumento = ?, generoId = ?\n"
                    + "where Id = ?;");
            System.out.println("estamos jodidos");
            stmt.setString(1, cliente.getPrimerNombre());
            stmt.setString(2, cliente.getSegundoNombre());
            stmt.setString(3, cliente.getPrimerApellido());
            stmt.setString(4, cliente.getSegundoApellido());
            stmt.setInt(5, cliente.getDocumento().getId());
            stmt.setString(6, cliente.getNumeroDocumento());
            stmt.setInt(7, cliente.getGenero().getId());
            stmt.setInt(8, cliente.getIdPersona());
            System.out.println("la id es: " + cliente.getIdPersona());
            stmt.executeUpdate();

            System.out.println("estamos un poco jodidos");
            PreparedStatement stment = connection.prepareStatement("update cliente set correo = ?, telefono = ?,\n"
                    + "NombreUsuario = ?, Clave = ?, direccion = ?,  where id = ?;");
                  

            System.out.println("estamos un poquito jodidos");
            stment.setString(1, cliente.getCorreo());
            stment.setString(2, cliente.getTelefono());
            stment.setString(3, cliente.getNombreUsuario());
            stment.setString(4, cliente.getClave());
            stment.setString(5, cliente.getDireccion());
            stment.setInt(6, cliente.getId());
            stment.executeUpdate();
            System.out.println("vamos mejorando");

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }


}
