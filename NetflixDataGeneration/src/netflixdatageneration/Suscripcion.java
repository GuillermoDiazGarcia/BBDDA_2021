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
public class Suscripcion {
    public int tipo;
    public float precio;
    public LocalDate fecha;
    public long suscripcion_ID;

    public Suscripcion(int tipo, float precio, LocalDate fecha, long suscripcion_ID) {
        this.tipo = tipo;
        this.precio = precio;
        this.fecha = fecha;
        this.suscripcion_ID = suscripcion_ID;
    }
    
    @Override
    public String toString(){
        String ret = "";
        ret += tipo + ",";
        ret += precio + ",";
        ret += "'" + fecha.getYear() + "-" + 
                fecha.getMonth() + "-" +
                fecha.getDayOfMonth() + "',";
        ret += suscripcion_ID + "\n";
        return ret;
    }
}
