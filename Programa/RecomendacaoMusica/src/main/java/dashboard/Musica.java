/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard;

/**
 *
 * @author Ana Komase
 */
public class Musica {
    private String nome;
    private double nota;
    private String nomeGenero;

    public double getNota() {
        return nota;
    }

    public void nota(double nota, Genero nomeGenero){
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    /*public void setNomeGenero(String nomeGenero) {
       // this.nomeGenero = nomeGenero;
    }
    public String getNomeGenero() {
        return nomeGenero;
    }*/
    
    
    
    Object getGenero() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
    

