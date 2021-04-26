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
public class Pago {
    public long pago_ID;
    public String metodo;
    public LocalDate fecha;
    public float cantidad;
    public long ID_cuenta_usuario;
    public long suscripcion_ID_suscripcion;

    public Pago(long pago_ID, String metodo, LocalDate fecha, float cantidad, long ID_cuenta_usuario, long suscripcion_ID_suscripcion) {
        this.pago_ID = pago_ID;
        this.metodo = metodo;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.ID_cuenta_usuario = ID_cuenta_usuario;
        this.suscripcion_ID_suscripcion = suscripcion_ID_suscripcion;
    }
    
    @Override
    public String toString(){
        String ret = "";
        ret += pago_ID + ",";
        ret += metodo + ",";
        ret += "'" + fecha.getYear() + "-" + 
                fecha.getMonth() + "-" +
                fecha.getDayOfMonth() + "',";
        ret += cantidad + ",";
        ret += ID_cuenta_usuario + ",";
        ret += suscripcion_ID_suscripcion + "\n";
        return ret;
    }
}
