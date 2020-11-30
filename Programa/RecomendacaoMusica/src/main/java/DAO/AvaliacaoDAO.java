/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dashboard.AvaliarMusica;
import java.util.ArrayList;
import java.util.List;
import loginCadastro.UsuarioLogado;

/**
 *
 * @author felip
 */
public class AvaliacaoDAO {

    public void inserir(AvaliarMusica avaliarMusica) throws SQLException {
        String insert = "insert into tb_musica(nome) values(?)";
        String insert2 = "insert into tb_avaliacao(nota) values(?)";

        try (Connection conexao = ConnectionFactory.conector2()) {
            PreparedStatement pst = conexao.prepareStatement(insert);
            pst.setString(1, avaliarMusica.getNomeMusica());
            //atualiza o banco de dados com os dados do formulário
            pst.executeUpdate();
        }

        try (Connection conexao = ConnectionFactory.conector2()) {
            //consulta ao banco de dados das caixas de texto
            PreparedStatement pst = conexao.prepareStatement(insert2);
            pst.setInt(1, (int) avaliarMusica.getNota());
            pst.executeUpdate();
        }
    }

    /**
     * @return @throws SQLException
     */
    public static List<AvaliarMusica> obterAvaliacoes() throws SQLException {
        int idUsuario = UsuarioLogado.getIdUsuarioLogado();
        String sql = "SELECT m.nome, a.nota\n"
                + "FROM tb_musica AS m\n"
                + "LEFT JOIN tb_avaliacao AS a ON m.idMusica = a.idMusica\n"
                + "WHERE a.idUsuario = ?;";
        List<dashboard.AvaliarMusica> avaliarMusicas = new ArrayList<>();

        try (Connection conexao = ConnectionFactory.conector2()) {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, idUsuario);
            ResultSet rs = pst.executeQuery();
            System.out.print("Sucesso");
            while (rs.next()) {
                String nome = rs.getString("nome");
                int nota = rs.getInt("nota");
                AvaliarMusica avaliarMusica = new AvaliarMusica();
                avaliarMusica.setNomeMusica(nome);
                avaliarMusica.setNota(nota);
                avaliarMusicas.add(avaliarMusica);

            }
            return avaliarMusicas;
        }

    }
}
