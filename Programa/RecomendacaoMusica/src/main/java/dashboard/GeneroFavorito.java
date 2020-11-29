package dashboard;

import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author felip
 */
public class GeneroFavorito {
    
    private Date registro;
    private String tipo;

    public int getIdGeneroFavorito() {
        return idGeneroFavorito;
    }

    public void setIdGeneroFavorito(int idGeneroFavorito) {
        this.idGeneroFavorito = idGeneroFavorito;
    }
    private int idGeneroFavorito;

    public Date getRegistro() {
        return registro;
    }

    public void setRegistro(Date registro) {
        this.registro = registro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
}
