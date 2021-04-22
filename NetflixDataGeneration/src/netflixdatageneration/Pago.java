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
public class Pago {
    public long codigoPago;
    public long codigoUsuario;
    public int dia;
    public int mes;
    public int anno;
    
    public Pago(long codigoPago, long codigoUsuario, int mes,int dia){
        this.codigoUsuario = codigoUsuario;
        this.mes = mes;
        this.dia = dia;
        this.anno = 2020;
    }
    
    @Override
    public String toString(){
        String ret = "";
        ret += codigoPago + ",";
        ret += codigoUsuario + ",";
        ret += dia + ",";
        ret += mes + ",";
        ret += anno + "\n";
        return ret;
    }
}
