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
public class Pelicula extends Contenido{
    public int duracion;

    public Pelicula(int numContenido, int tipoSuscripcion, int duracion) {
        super(numContenido, tipoSuscripcion);
        this.duracion = duracion;
    }
    @Override
    public String toString(){
        String ret = "";
        ret += numContenido + ",";
        ret += tipoSuscripcion + ",";
        for(String nav:generos){
            ret += nav + ",";
        }
        ret += duracion + ",";
        return ret;
    }
}
