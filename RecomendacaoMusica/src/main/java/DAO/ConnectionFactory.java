/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author giova
 */
public class ConnectionFactory {
    
    public static Connection conector(){
        Connection conexao = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/dbusuarios?useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String password = "taekook23081564";
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ConnectionFactory" + e.getMessage());
            return null;
        } catch (ClassNotFoundException ex) {
           return null;
        }
      }  
}
