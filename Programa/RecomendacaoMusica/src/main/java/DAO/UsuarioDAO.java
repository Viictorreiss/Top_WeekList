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
import loginCadastro.UsuarioLogado;

/**
 *
 * @author giova
 */
public class UsuarioDAO {

    public static boolean logar(Usuarios usuarios) throws SQLException {
        String sql = "select * from tb_usuario where login=? and Senha=?";

        try (Connection conexao = ConnectionFactory.conector()) {
            //consulta ao banco de dados das caixas de texto
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, usuarios.getNomeUsuario());
            pst.setString(2, usuarios.getSenhaUsuario());
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) { //next significa nextline e ele retorna SE existe próxima linha,
                    //SE não existir a próxima linha, retorna falso, ou seja, ele errou o login
                    int idUsuario = rs.getInt("idUsuario");
                    UsuarioLogado.setIdUsuarioLogado(idUsuario);
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public static boolean adicionar(Usuarios usuarios) throws SQLException {
        String sql = "insert into tb_usuario(login, Senha) values(?,?)";

        try (Connection conexao = ConnectionFactory.conector()) {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, usuarios.getNomeUsuario());
            pst.setString(2, usuarios.getSenhaUsuario());
            //atualiza o banco de dados com os dados do formulário
            pst.executeUpdate();
            return true;
        }

    }
}
