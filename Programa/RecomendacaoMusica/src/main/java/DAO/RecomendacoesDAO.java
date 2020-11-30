/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dashboard.GeneroFavorito;
import dashboard.Recomendacoes;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import loginCadastro.UsuarioLogado;

/**
 *
 * @author felip
 */
public class RecomendacoesDAO {

    public static List<dashboard.Recomendacoes> obterRecomendacoes() throws SQLException {
        int idUsuario = UsuarioLogado.getIdUsuarioLogado();
        String sql = "Select m.nome, avg (a.nota) AS nota from tb_generofavorito AS f\n"
                + "LEFT JOIN tb_colecao AS c ON f.idGenero = c.idGenero\n"
                + "LEFT JOIN tb_musica AS m ON c.idMusica = m.idMusica\n"
                + "LEFT JOIN tb_avaliacao AS a ON a.idMusica = m.idMusica\n"
                + "where f.idUsuario = ? AND m.idMusica not in (select idMusica from tb_avaliacao where idUsuario = ?)\n"
                + "Group by m.nome\n"
                + "order by nota DESC\n"
                + "limit 5;";
        List<dashboard.Recomendacoes> recomendacoes = new ArrayList<>();

        try (Connection conexao = ConnectionFactory.conector2()) {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, idUsuario);
            pst.setInt(2, idUsuario);
            ResultSet rs = pst.executeQuery();
            System.out.print("Sucesso");
            while (rs.next()) {
                double nota = rs.getDouble("nota");
                String nome = rs.getString("nome");
                Recomendacoes recomendacao = new Recomendacoes();
                recomendacao.setNota(nota);
                recomendacao.setNome(nome);
                recomendacoes.add(recomendacao);
            }
            return recomendacoes;
        }

    }

}
