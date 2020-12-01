/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author giova
 */
public class ConnectionFactory {
    public Statement stm;
    public ResultSet rs;
    public Connection conexao;
    
    public static Connection conector(){
        Connection conexao;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/db_recomendacoes?useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String password = "admin123";
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
    
    public static Connection conector2(){
        Connection conexao;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/db_recomendacoes?useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String password = "admin123";
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
    
    public void executaSQL(String sql) throws SQLException{
        stm = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        rs = stm.executeQuery(sql);
    }
}
