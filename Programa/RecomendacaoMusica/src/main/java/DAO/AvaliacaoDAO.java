/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dashboard.Avaliacao;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import loginCadastro.Usuarios;

/**
 *
 * @author felip
 */
public class AvaliacaoDAO {

    public static ArrayList<Avaliacao> listar(Usuarios usuarios) throws SQLException {
        ArrayList <Avaliacao> avaliacoes = new ArrayList();
        String sql = "select idAvaliacao, idUsuario, idMusica, nota from tbavaliacao";
        try (Connection conexao = ConnectionFactory.conector()) {
            //consulta ao banco de dados das caixas de texto
            PreparedStatement pst = conexao.prepareStatement(sql);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Avaliacao avaliacao = new Avaliacao();
                    avaliacao.setIdAvaliacao(rs.getInt("idAvaliacao"));
                    avaliacao.setIdUsuario(rs.getInt("idUsuario"));
                    avaliacao.setIdMusica(rs.getInt("idMusica"));
                    avaliacao.setNota(rs.getInt("nota"));
                    avaliacoes.add(avaliacao);
                }

            }

        }
        return avaliacoes;
    }

}
