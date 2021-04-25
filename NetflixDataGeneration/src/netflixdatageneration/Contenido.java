/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflixdatageneration;

import java.time.LocalDate;

/**gsdgseged
 *
 * @author Guillermo
 */
public class Contenido {
    public long producto_ID;
    public String titulo;
    public LocalDate fecha_lanzamiento;
    public int valoracion;

    public Contenido(long producto_ID, String titulo, LocalDate fecha_lanzamiento, int valoracion) {
        this.producto_ID = producto_ID;
        this.titulo = titulo;
        this.fecha_lanzamiento = fecha_lanzamiento;
        this.valoracion = valoracion;
    }

    @Override
    public String toString(){
        String ret = "";
        ret += producto_ID + ",";
        ret += titulo + ",";
        ret += "'" + fecha_lanzamiento.getYear() + "-" + 
                fecha_lanzamiento.getMonth() + "-" +
                fecha_lanzamiento.getDayOfMonth() + "',";
        ret += valoracion + "\n";
        return ret;
    }
}
