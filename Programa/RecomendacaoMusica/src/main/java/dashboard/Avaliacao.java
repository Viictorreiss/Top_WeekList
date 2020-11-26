/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard;

/**
 *
 * @author felip
 */
public class Avaliacao {
    
    private int idAvaliacao;
    private int idUsuario;
    private int idMusica;
    private int nota;
    
      public Avaliacao(int idAvaliacao, int idUsuario, int idMusica, int nota) {
        this.idAvaliacao = idAvaliacao;
        this.idUsuario = idUsuario;
        this.idMusica = idMusica;
        this.nota = nota;
    }
      
      public Avaliacao(){
      
      }

    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdMusica() {
        return idMusica;
    }

    public void setIdMusica(int idMusica) {
        this.idMusica = idMusica;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

  
    
    
    
}
