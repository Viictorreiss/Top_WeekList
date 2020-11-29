/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dashboard.GeneroFavorito;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import loginCadastro.UsuarioLogado;

/**
 *
 * @author giova
 */
public class ListaGenerosDAO {

    public static List<dashboard.GeneroFavorito> obterGeneros() throws SQLException {
        int idUsuario = UsuarioLogado.getIdUsuarioLogado();
        String sql = "SELECT r.idGeneroFavorito, r.registro, g.tipo\n"
                + "FROM tb_generofavorito AS r\n"
                + "LEFT JOIN tb_genero AS g ON g.idGenero = r.idGenero\n"
                + "WHERE r.idUsuario = ?;";
        List<dashboard.GeneroFavorito> generos = new ArrayList<>();

        try (Connection conexao = ConnectionFactory.conector2()) {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, idUsuario);
            ResultSet rs = pst.executeQuery();
            System.out.print("Sucesso");
            while (rs.next()) {
                Date registro = rs.getDate("registro");
                String tipo = rs.getString("tipo");
                int idGeneroFavorito = rs.getInt("idGeneroFavorito");
                GeneroFavorito generoFavorito = new GeneroFavorito();
                generoFavorito.setRegistro(registro);
                generoFavorito.setTipo(tipo);
                generoFavorito.setIdGeneroFavorito(idGeneroFavorito);
                generos.add(generoFavorito);

            }
            return generos;
        }

    }

    public static void remover(int idGeneroFavorito) {
        try (Connection conexao = ConnectionFactory.conector2()) {
            PreparedStatement pstm;
            pstm = conexao.prepareStatement("DELETE FROM tb_generofavorito WHERE idGeneroFavorito = ?");

            pstm.setInt(1, idGeneroFavorito);

            pstm.execute();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir contato do banco de"
                    + "dados " + e.getMessage());
        }
    }
    
    public static void adicionar(int idGeneroFavorito) {
        try (Connection conexao = ConnectionFactory.conector2()) {
            PreparedStatement pstm;
            pstm = conexao.prepareStatement("INSERT INTO tb_generofavorito (idUsuario, idGenero, registro) values (?,?,'2020-11-30')");

            pstm.setInt(1, UsuarioLogado.getIdUsuarioLogado());
            pstm.setInt(1, idGeneroFavorito);

            pstm.execute();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir contato do banco de"
                    + "dados " + e.getMessage());
        }
    }
    
}
