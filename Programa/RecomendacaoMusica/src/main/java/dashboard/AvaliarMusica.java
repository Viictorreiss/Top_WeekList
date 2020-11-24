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
    private double notas;
    private String genero;

    
    public AvaliarMusica(String nomeMusica, double nota, String genero){
        this.nomeMusica = nomeMusica;
        this.genero = genero;
        
    }
    public AvaliarMusica(){
        
    }
    
    public String getNomeMusica() {
        return nomeMusica;
    }

    public void setNomeMusica(String nomeMusica) {
        this.nomeMusica = nomeMusica;
    }

    public double getNota() {
        return notas;
    }

    public void setNota(double nota) {
        this.notas = nota;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
   
}
