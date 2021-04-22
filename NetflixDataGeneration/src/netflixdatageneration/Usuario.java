/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflixdatageneration;


/**
 *
 * @author Guillermo
 */
public class Usuario{
    public long codigoUsuario;
    public int tipoSuscripcion;
    
    public Usuario(long codigoUsuario, int tipoSuscripcion){
        this.codigoUsuario = codigoUsuario;
        this.tipoSuscripcion = tipoSuscripcion;
    }
    @Override
    public String toString(){
        String ret = "";
        ret += codigoUsuario + ",";
        ret += tipoSuscripcion + "\n";
        return ret;
    }
}
