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
public class Pelicula{
    public int duracion;
    public long producto_ID_contenidos;

    public Pelicula(int duracion, long producto_ID_contenidos) {
        this.duracion = duracion;
        this.producto_ID_contenidos = producto_ID_contenidos;
    }
    
    @Override
    public String toString(){
        String ret = "";
        ret += duracion + ",";
        ret += producto_ID_contenidos + "\n";
        return ret;
    }
}
