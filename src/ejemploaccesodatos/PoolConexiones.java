/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploaccesodatos;

import java.sql.Connection;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 * @author Yo
 */
public class PoolConexiones 
{
    Connection con;
    public PoolConexiones() 
    {
        con = null;
        BasicDataSource bdSource = new BasicDataSource();
        bdSource.setUrl("jdbc:mysql://localhost:3306/discografica?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        bdSource.setUsername("root");
        bdSource.setPassword("");
        try 
        {
            //DataSource nos reserva una conexión y nos la devuelve
            con = bdSource.getConnection();
            if (con != null) 
            {
                System.out.println("Conexión creada satisfactoriamente");
            } 
            else 
            {
                System.out.println("No se puede crear una nueva conexión");
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Error: " + e.toString());
        }
    }
}
