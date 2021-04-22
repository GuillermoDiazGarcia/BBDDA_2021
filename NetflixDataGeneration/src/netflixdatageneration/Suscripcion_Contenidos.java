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
public class Suscripcion_Contenidos {
    public LocalDate fecha_producto_suscripcion;
    public long suscripcion_ID_suscripcion;
    public long producto_ID_contenidos;

    public Suscripcion_Contenidos(LocalDate fecha_producto_suscripcion, long suscripcion_ID_suscripcion, long producto_ID_contenidos) {
        this.fecha_producto_suscripcion = fecha_producto_suscripcion;
        this.suscripcion_ID_suscripcion = suscripcion_ID_suscripcion;
        this.producto_ID_contenidos = producto_ID_contenidos;
    }
    
    @Override
    public String toString(){
        String ret = "";
        ret += "'" + fecha_producto_suscripcion.getYear() + "-" + 
                fecha_producto_suscripcion.getMonth() + "-" +
                fecha_producto_suscripcion.getDayOfMonth() + "',";
        ret += suscripcion_ID_suscripcion + ",";
        ret += producto_ID_contenidos +"\n";
        return ret;
    }
}
