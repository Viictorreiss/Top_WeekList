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


/**
 *
 * @author felip
 */
public class AvaliacaoDAO {
    
    public void inserir(AvaliarMusica avaliarMusica) throws SQLException{
        String insert = "insert into tb_musica(nome) values(?)";
        String insert2 = "insert into tb_avaliacao(nota) values(?)";
        
        try (Connection conexao = ConnectionFactory.conector2()){
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
     * @return
     * @throws SQLException
     */
    public static List<AvaliarMusica> obterAvaliacoes() throws SQLException{
       String select = "select * from tb_musica";
       String select2 = "select * from tb_avaliacao";
        List<AvaliarMusica> avaliacoes = new ArrayList<>();
        try (Connection conexao = ConnectionFactory.conector2()){
            PreparedStatement pst = conexao.prepareStatement(select);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String nomeMusica = rs.getString("nome");
                AvaliarMusica avaliarMusica = new AvaliarMusica(nomeMusica);
                avaliarMusica.add(avaliarMusica);
            }
        
        }
        try (Connection conexao = ConnectionFactory.conector2()){
            PreparedStatement pst = conexao.prepareStatement(select2);
            ResultSet rs;
            rs = pst.executeQuery();
            while (rs.next()) {
                int nota = rs.getInt("nota");
                AvaliarMusica avaliarMusica = new AvaliarMusica(nota);
                avaliarMusica.add(avaliarMusica);
            }
            return avaliacoes;
         
        }
        
    }
}