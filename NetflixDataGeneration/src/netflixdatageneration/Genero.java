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
public class Genero {
    public long genero_ID;
    public String descripcion;

    public Genero(long genero_ID, String descripcion) {
        this.genero_ID = genero_ID;
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString(){
        String ret = "";
        ret += genero_ID + ",";
        ret += descripcion + "\n";
        return ret;
    }
}
