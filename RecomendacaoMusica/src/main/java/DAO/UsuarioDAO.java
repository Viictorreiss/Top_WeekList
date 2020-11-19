/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import loginCadastro.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author giova
 */
public class UsuarioDAO {
    
     public static boolean logar(Usuarios usuarios) throws SQLException {
        String sql = "select * from tbusuarios where nomeUsuario=? and senhaUsuario=?";
        try (Connection conexao = ConnectionFactory.conector()){
            //consulta ao banco de dados das caixas de texto
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, usuarios.getNomeUsuario());
            pst.setString(2, usuarios.getSenhaUsuario());
            try (ResultSet rs = pst.executeQuery()){
                return rs.next();
            } 
        }     
    }
     
    public static boolean adicionar(Usuarios usuarios) throws SQLException{
        String sql = "insert into tbusuarios(nomeUsuario, senhaUsuario) values(?,?)";
      
        try (Connection conexao = ConnectionFactory.conector()){
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, usuarios.getNomeUsuario());
            pst.setString(2, usuarios.getSenhaUsuario());
            //atualiza o banco de dados com os dados do formulário
            pst.executeUpdate();
            return true;
        }
         
    }  
}
            


   
