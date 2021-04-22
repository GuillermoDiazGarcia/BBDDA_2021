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
public class Genero_Contenidos {
    public long genero_ID_genero;
    public long producto_ID_contenidos;

    public Genero_Contenidos(long genero_ID_genero, long producto_ID_contenidos) {
        this.genero_ID_genero = genero_ID_genero;
        this.producto_ID_contenidos = producto_ID_contenidos;
    }
    
    @Override
    public String toString(){
        String ret = "";
        ret += genero_ID_genero + ",";
        ret += producto_ID_contenidos + "\n";
        return ret;
    }
}
