/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflixdatageneration;

import java.time.LocalDate;

/**
 *
 * @author Guillermo
 */
public class Serie{
    public int capitulos;
    public int temporadas;
    public long producto_ID_contenidos;

    public Serie(int capitulos, int temporadas, long producto_ID_contenidos) {
        this.capitulos = capitulos;
        this.temporadas = temporadas;
        this.producto_ID_contenidos = producto_ID_contenidos;
    }
    
    @Override
    public String toString(){
        String ret = "";
        ret += capitulos + ",";
        ret += temporadas + ",";
        ret += producto_ID_contenidos + "\n";
        return ret;
    }
}
