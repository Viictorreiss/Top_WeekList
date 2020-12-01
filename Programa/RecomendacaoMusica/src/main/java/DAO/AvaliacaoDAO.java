/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dashboard.Avaliacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dashboard.AvaliarMusica;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import loginCadastro.UsuarioLogado;

/**
 *
 * @author felip
 */
public class AvaliacaoDAO {

    /**
     * @return @throws SQLException
     */
    public static List<AvaliarMusica> obterAvaliacoes() throws SQLException {
        int idUsuario = UsuarioLogado.getIdUsuarioLogado();
        String sql = "SELECT a.idAvaliacao, m.nome, a.nota\n"
                + "FROM tb_avaliacao AS a\n"
                + "LEFT JOIN tb_musica AS m ON a.idMusica = m.idMusica\n"
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
                int idAvaliacao = rs.getInt("idAvaliacao");
                AvaliarMusica avaliarMusica = new AvaliarMusica();
                avaliarMusica.setNome(nome);
                avaliarMusica.setNota(nota);
                avaliarMusica.setIdAvaliacao(idAvaliacao);
                avaliarMusicas.add(avaliarMusica);

            }
            return avaliarMusicas;
        }

    }
    
   public static List<Avaliacao> obterOutrasAvaliacoes() throws SQLException {
         int idUsuario = UsuarioLogado.getIdUsuarioLogado();
            String sql = "SELECT m.idMusica, m.nome\n"
               + "FROM tb_musica AS m\n"
               + "where m.idMusica not in (select idMusica from tb_avaliacao where idUsuario = ? )";
        List<dashboard.Avaliacao> avaliacoes = new ArrayList<>();

        try (Connection conexao = ConnectionFactory.conector2()) {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, idUsuario);
            ResultSet rs = pst.executeQuery();
            System.out.print("Sucesso");
            while (rs.next()) {
                int idMusica = rs.getInt("idMusica");
                String nome = rs.getString("nome");
                //Passo 1 - Desta linha pra cima estamos apenas pegando os resultados do banco de dados
                
                //Passo 2 - Desta linha para baixo, vamos preencher uma model que fará com que possamos
                //trafegar a aplicação Java e o Banco de dados.
                
                Avaliacao avaliacao = new Avaliacao();
                avaliacao.setIdMusica(idMusica);
                avaliacao.setNome(nome);
                
                //Passo 3 - Adiciona na Lista de Retorno para poder upar para o programa o que está no banco de dados.
                avaliacoes.add(avaliacao); 
                
                
                
                //Dica do Fezão: Quando a classe ela representa uma única coisa, usa-se o nome no singular.
                //Só usa-se no plural quando você tem uma lista de uma mesma coisa que está oculta na classe
                //Inclusive, usa-se na maioria das vezes no singular, e se necessário você altera.
                // 

            }
            return avaliacoes;
        }

    }
    
     public static boolean adicionar(int idMusica, int nota) {
        try (Connection conexao = ConnectionFactory.conector2()) {
            PreparedStatement pstm;
            pstm = conexao.prepareStatement("INSERT INTO tb_avaliacao (idUsuario, idMusica,  nota) values (?,?, ?)");

            pstm.setInt(1, UsuarioLogado.getIdUsuarioLogado()); //o número significa qual interrogação você quer trocar, portanto tem que seguir a ordem.
            pstm.setInt(2, idMusica);
            pstm.setInt(3, nota);


            pstm.execute();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar a nota"
                    + "dados " + e.getMessage());
        }
        return true;
    }

}
