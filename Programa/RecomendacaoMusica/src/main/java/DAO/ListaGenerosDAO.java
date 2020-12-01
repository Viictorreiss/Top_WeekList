/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dashboard.Genero;
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

    public static List<dashboard.GeneroFavorito> obterGenerosFavoritos() throws SQLException {
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
    
    public static List<dashboard.Genero> obterGenerosNaoFavoritos() throws SQLException {
         int idUsuario = UsuarioLogado.getIdUsuarioLogado();
            String sql = "SELECT g.idGenero, g.tipo\n"
                    + "from tb_genero as g\n"
                    + "where g.idGenero not in (select idGenero from tb_generofavorito where idUsuario = ? );";
        List<dashboard.Genero> generos = new ArrayList<>();

        try (Connection conexao = ConnectionFactory.conector2()) {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, idUsuario);
            ResultSet rs = pst.executeQuery();
            System.out.print("Sucesso");
            while (rs.next()) {
                int idGenero = rs.getInt("idGenero");
                String tipo = rs.getString("tipo");
                //Passo 1 - Desta linha pra cima estamos apenas pegando os resultados do banco de dados
                
                //Passo 2 - Desta linha para baixo, vamos preencher uma model que fará com que possamos
                //trafegar a aplicação Java e o Banco de dados.
                
                Genero genero = new Genero();
                genero.setIdGenero(idGenero);
                genero.setTipo(tipo);
                
                //Passo 3 - Adiciona na Lista de Retorno para poder upar para o programa o que está no banco de dados.
                generos.add(genero); 
                
                
                
                //Dica do Fezão: Quando a classe ela representa uma única coisa, usa-se o nome no singular.
                //Só usa-se no plural quando você tem uma lista de uma mesma coisa que está oculta na classe
                //Inclusive, usa-se na maioria das vezes no singular, e se necessário você altera.
                // 

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
    
    public static void adicionar(int idGenero) {
        try (Connection conexao = ConnectionFactory.conector2()) {
            PreparedStatement pstm;
            pstm = conexao.prepareStatement("INSERT INTO tb_generofavorito (idUsuario, idGenero, registro) values (?,?,'2020-11-30')");

            pstm.setInt(1, UsuarioLogado.getIdUsuarioLogado()); //o número significa qual interrogação você quer trocar, portanto tem que seguir a ordem.
            pstm.setInt(2, idGenero);

            pstm.execute();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir contato do banco de"
                    + "dados " + e.getMessage());
        }
    }
    
}
