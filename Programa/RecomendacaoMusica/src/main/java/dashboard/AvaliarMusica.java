package dashboard;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ana Komase
 */
public class AvaliarMusica {
    private String nomeMusica;
    private int nota;
    private String genero;
    
    /**
     *
     * @param genero
     * @param nomeMusica
     */
    public AvaliarMusica(String genero, String nomeMusica, int nota){
       this.nomeMusica = nomeMusica;
       this.genero = genero;
       this.nota = nota;
        
    }

    public AvaliarMusica(int nota) {
        this.nota = nota;
    }

    public AvaliarMusica(String nomeMusica) {
        this.nomeMusica = nomeMusica;
    }
  
 
    public String getNomeMusica() {
        return nomeMusica;
    }

    public void setNomeMusica(String nomeMusica) {
        this.nomeMusica = nomeMusica;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void add(AvaliarMusica avaliarMusica) {
    }

 
   
}
