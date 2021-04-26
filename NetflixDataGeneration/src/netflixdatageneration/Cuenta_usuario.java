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
public class Cuenta_usuario {
    public long ID;
    public String nombre, direccion, e_mail;
    public int telefono;
    public long suscripcion_ID_suscripcion;

    public Cuenta_usuario(long ID, String nombre, String direccion, String e_mail, int telefono, long suscripcion_ID_suscripcion) {
        this.ID = ID;
        this.nombre = nombre;
        this.direccion = direccion;
        this.e_mail = e_mail;
        this.telefono = telefono;
        this.suscripcion_ID_suscripcion = suscripcion_ID_suscripcion;
    }
    
    @Override
    public String toString() {
        String ret = "";
        ret += ID + ",";
        ret += nombre + ",";
        ret += direccion + ",";
        ret += e_mail + ",";
        ret += telefono + ",";
        ret += suscripcion_ID_suscripcion + "\n";
        return ret;
    }
}
