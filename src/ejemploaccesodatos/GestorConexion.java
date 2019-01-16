/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploaccesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Yo
 */
public class GestorConexion 
{
    Connection conn1;
    public GestorConexion() 
    {
        conn1 = null;
        try 
        {
            String url1 = "jdbc:mysql://localhost:3306/discografica?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String user = "root";
            String password = "";
            conn1 = (Connection) DriverManager.getConnection(url1, user, password);
            if (conn1 != null) 
            {
                System.out.println("Conectado a discográfica…");
            }
        } 
        catch (SQLException ex) 
        {
            System.out.println("ERROR: dirección o usuario/clave no válida");
            ex.printStackTrace();
        }
    }
    
    public void cerrar_conexion() 
    {
        try 
        {
            conn1.close();
            System.out.println("conexión cerrada");
        } 
        catch (SQLException ex) 
        {
            System.out.println("ERROR:al cerrar la conexión");
            ex.printStackTrace();
        }
    }
    
    public void annadirColumna()
    {
        try 
        {
            Statement sta = conn1.createStatement();
            sta.executeUpdate("ALTER TABLE album ADD anno_publicacion YEAR");
            sta.close();
        } 
        catch (Exception e) 
        {
            System.out.println("ERROR");
            e.printStackTrace();
        }
    }

    public void borraColumna()
    {
        try 
        {
            Statement sta = conn1.createStatement();
            sta.executeUpdate("DROP TABLE album");
            sta.close();
        } 
        catch (Exception e) 
        {
            System.out.println("ERROR");
            e.printStackTrace();
        }
    }
    
    public void insertar() 
    {
        try {
            // Crea un statement
            Statement sta = conn1.createStatement();
            // Ejecuta la inserción
            sta.executeUpdate("INSERT INTO album VALUES (2,'Greatest Hits','Queen')");
            // Cierra el statement
            sta.close();
        } 
        catch (SQLException ex) 
        {
            System.out.println("ERROR:al hacer un Insert");
            ex.printStackTrace();
        }
    }

}
