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
public class Serie extends Contenido{
    public int capitulos;
    public int temporadas;
    public Serie(int numContenido, int tipoSuscripcion, int capitulos, int temporadas) {
        super(numContenido, tipoSuscripcion);
        this.capitulos = capitulos;
        this.temporadas = temporadas;
    }
    @Override
    public String toString(){
        String ret = "";
        ret += numContenido + ",";
        ret += tipoSuscripcion + ",";
        for(String nav:generos){
            ret += nav + ",";
        }
        ret += capitulos + ",";
        ret += temporadas + ",";
        return ret;
    }
    
}
