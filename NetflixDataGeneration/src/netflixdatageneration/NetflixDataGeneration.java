/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflixdatageneration;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

/**
 *
 * @author Guillermo
 */
public class NetflixDataGeneration {
    private static Random rand = new Random();
    private static final long numUsuarios = 2000000;
    private static final int numTiposSuscripcion = 100;
    private static final int numPagos = 12;
    private static final int maxDias = 28;
    private static final long numContenidos = 20000000;
    private static String[] tiposContenido = new String[2];
    private static final int numGeneros = 20;
    private static final int maxGenerosPorContenido = 6;
    private static final int minGenerosPorContenido = 1;
    private static final int maxDurPeliculas = 120;
    private static final int minDurPeliculas = 80;
    private static final int maxCapitulos = 20;
    private static final int minCapitulos = 10;
    private static final int maxTemporadas = 15;
    private static final int minTemporadas = 1;
    private static final int maxValoracion = 10;
    private static final int minValoracion = 1;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //rellenarUsuarios();
        //System.out.println("Finish usuarios + pagos");
        rellenarContenidos();
        System.out.println("Finish");
    }
    /*private static void rellenarUsuarios() throws IOException {
        long contadorVueltas;
        int tipoSuscripcion;
        long numPago = 0;
        for(contadorVueltas=0;contadorVueltas<numUsuarios;contadorVueltas++){
            tipoSuscripcion = rand.nextInt(numTiposSuscripcion)+1;
            FileWriter fwUsuarios = new FileWriter("../datos_Netflix/usuarios.txt",true);
            BufferedWriter bwUsuarios = new BufferedWriter(fwUsuarios);
            bwUsuarios.write((new Usuario(contadorVueltas, tipoSuscripcion)).toString());
            bwUsuarios.close();
            for(int i=0;i<numPagos;i++){
                FileWriter fwPagos = new FileWriter("../datos_Netflix/pagos.txt",true);
                BufferedWriter bwPagos = new BufferedWriter(fwPagos);
                bwPagos.write((new Pago(numPago,contadorVueltas,i+1,(rand.nextInt(maxDias))+1)).toString());
                bwPagos.close();
                numPago++;
            }
            if(contadorVueltas%10000 == 0) System.out.println("usuario "+contadorVueltas);
        }
    }*/
    private static void rellenarContenidos() throws IOException{
        long contador;
        FileWriter fwContenidos = new FileWriter("../datos_Netflix/contenidos.txt",true);
        BufferedWriter bwContenidos = new BufferedWriter(fwContenidos);
        FileWriter fwPeliculas = new FileWriter("../datos_Netflix/peliculas.txt",true);
        BufferedWriter bwPeliculas = new BufferedWriter(fwPeliculas);
        FileWriter fwSeries = new FileWriter("../datos_Netflix/series.txt",true);
        BufferedWriter bwSeries = new BufferedWriter(fwSeries);
        for(contador=0;contador<numContenidos;contador++){
            bwContenidos.write(new Contenido(contador,"titulo"+contador,
                    LocalDate.of(1950+rand.nextInt(70), 1+rand.nextInt(11),
                    1+rand.nextInt(27)),1+rand.nextInt(9)).toString());
            switch(rand.nextInt(1)){
                case 0:         //Peliculas
                    bwPeliculas.write(new Pelicula(80+rand.nextInt(40),contador).toString());
                case 1:         //Series
                    bwSeries.write(new Serie(10+rand.nextInt(20),1+rand.nextInt(14),contador).toString());
            }
            if(contador%10000 == 0) System.out.println("contenido "+contador);
        }
        bwContenidos.close();
        bwPeliculas.close();
        bwSeries.close();
    }
}
