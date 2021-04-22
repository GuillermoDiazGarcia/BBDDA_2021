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
public abstract class Contenido {
    public int numContenido;
    public int tipoSuscripcion;
    public String[] generos = new String[6];

    public Contenido(int numContenido, int tipoSuscripcion) {
        this.numContenido = numContenido;
        this.tipoSuscripcion = tipoSuscripcion;
        this.generos[0] = "";
        this.generos[1] = "";
        this.generos[2] = "";
        this.generos[3] = "";
        this.generos[4] = "";
        this.generos[5] = "";
    }
    
    public void addGenero(String gen, int index){
        generos[index] = gen;
    }
}
