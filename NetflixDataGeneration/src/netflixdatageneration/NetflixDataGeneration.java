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
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author Guillermo
 */
public class NetflixDataGeneration {
    private static final Random rand = new Random();
    private static final HashMap<Integer,Float> tiposSuscripcion = new HashMap<>();
    private static final long numUsuarios = 2000000;
    private static final int numTiposSuscripcion = 100;
    private static final long numContenidos = 20000000;
    private static final int numGeneros = 20;
    private static final int maxGenerosPorContenido = 6;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        rellenarTiposSuscripcion();
        System.out.println("End Suscripciones, start Usuarios");
        rellenarUsuarios();
        System.out.println("End Usuarios, start Generos");
        rellenarGeneros();
        System.out.println("End Generos, start Contenidos");
        rellenarContenidos();
        System.out.println("Finish");
    }
    private static void rellenarTiposSuscripcion() throws IOException{
        FileWriter fwSuscripciones = new FileWriter("../datos_Netflix/suscripciones.txt",true);
        BufferedWriter bwSuscripciones = new BufferedWriter(fwSuscripciones);
        for(int i=1;i<=numTiposSuscripcion;i++){
            float precio = rand.nextInt(20) + ((float)(rand.nextInt(100))/100);
            tiposSuscripcion.put(i, precio);
            bwSuscripciones.write(new Suscripcion(i,precio,
                    LocalDate.of(2000+rand.nextInt(19),1+rand.nextInt(12),1+rand.nextInt(27)),
                    i).toString());
        }
        bwSuscripciones.close();
    }
    private static void rellenarGeneros() throws IOException{
        int contador;
        FileWriter fwGeneros = new FileWriter("../datos_Netflix/generos.txt",true);
        BufferedWriter bwGeneros = new BufferedWriter(fwGeneros);
        for(contador=0;contador<numGeneros;contador++){
            bwGeneros.write(new Genero(contador,"genero"+contador).toString());
        }
        bwGeneros.close();
    }
    private static void rellenarUsuarios() throws IOException{
        long contador;
        float cantidad;
        FileWriter fwUsuarios = new FileWriter("../datos_Netflix/cuentas_usuario.txt",true);
        BufferedWriter bwUsuarios = new BufferedWriter(fwUsuarios);
        FileWriter fwPagos1 = new FileWriter("../datos_Netflix/pagos1.txt",true);
        BufferedWriter bwPagos1 = new BufferedWriter(fwPagos1);
        FileWriter fwPagos2 = new FileWriter("../datos_Netflix/pagos2.txt",true);
        BufferedWriter bwPagos2 = new BufferedWriter(fwPagos2);
        for(contador=0;contador<1000000;contador++){
            int tipo = 1 + rand.nextInt(100);
            bwUsuarios.write(new Cuenta_usuario(contador,"nombre"+contador,"direccion"+contador,
                        "e-mail"+contador,rand.nextInt(100000000)+600000000,tipo).toString());
            for(int i=1;i<=12;i++){
                bwPagos1.write(new Pago((contador*12)+i,"metodo"+contador,LocalDate.of(2020,i,1+rand.nextInt(28)),
                            tiposSuscripcion.get(tipo),contador,tipo).toString());
            }
            if(contador%10000 == 0) System.out.println("usuario "+contador);
        }
        System.out.println("Cambio de archivo de pagos");
        for(contador=contador;contador<numUsuarios;contador++){
            int tipo = 1 + rand.nextInt(100);
            bwUsuarios.write(new Cuenta_usuario(contador,"nombre"+contador,"direccion"+contador,
                        "e-mail"+contador,rand.nextInt(100000000)+600000000,tipo).toString());
            for(int i=1;i<=12;i++){
                bwPagos2.write(new Pago((contador*12)+i,"metodo"+contador,LocalDate.of(2020,i,1+rand.nextInt(28)),
                            tiposSuscripcion.get(tipo),contador,tipo).toString());
            }
            if(contador%10000 == 0) System.out.println("usuario "+contador);
        }
        bwUsuarios.close();
        bwPagos1.close();
        bwPagos2.close();
    }
    private static void rellenarContenidos() throws IOException{
        long contador;
        int num_generos, nuevoGenero;
        int[] generosContenido;
        boolean checker;
        FileWriter fwContenidos = new FileWriter("../datos_Netflix/contenidos.txt",true);
        BufferedWriter bwContenidos = new BufferedWriter(fwContenidos);                                 //BW para contenidos.txt
        FileWriter fwGeneroContenidos = new FileWriter("../datos_Netflix/genero_contenidos.txt",true);
        BufferedWriter bwGeneroContenidos = new BufferedWriter(fwGeneroContenidos);
        FileWriter fwPeliculas = new FileWriter("../datos_Netflix/peliculas.txt",true);
        BufferedWriter bwPeliculas = new BufferedWriter(fwPeliculas);
        FileWriter fwSeries = new FileWriter("../datos_Netflix/series.txt",true);
        BufferedWriter bwSeries = new BufferedWriter(fwSeries);
        FileWriter fwSuscripcionContenidos = new FileWriter("../datos_Netflix/suscripcion_contenidos.txt",true);
        BufferedWriter bwSuscripcionContenidos = new BufferedWriter(fwSuscripcionContenidos);
        for(contador=0;contador<numContenidos;contador++){
            bwContenidos.write(new Contenido(contador,"titulo"+contador,
                    LocalDate.of(1950+rand.nextInt(71), 1+rand.nextInt(12),
                    1+rand.nextInt(28)),1+rand.nextInt(10)).toString());
            num_generos = 1 + rand.nextInt(maxGenerosPorContenido);
            generosContenido = new int[num_generos];
            for(int i=0;i<num_generos;i++){         //Comprueba que el género no esté repetido para ese contenido
                nuevoGenero = rand.nextInt(20);
                checker = false;
                for(int j=0;j<=i;j++){
                    if(generosContenido[j]==nuevoGenero) checker = true;
                }
                if(!checker) bwGeneroContenidos.write(new Genero_Contenidos(rand.nextInt(20),contador).toString());
                else i--;                           //Si ese género ya estaba añadido para ese contenido no se añade y se repite el proceso
            }
            bwSuscripcionContenidos.write(new Suscripcion_Contenidos(LocalDate.of(2020,1,1),
                    1+rand.nextInt(100),contador).toString());
            switch(rand.nextInt(2)){
                case 0:         //Peliculas
                    bwPeliculas.write(new Pelicula(80+rand.nextInt(41),contador).toString());
                case 1:         //Series
                    bwSeries.write(new Serie(10+rand.nextInt(21),1+rand.nextInt(15),contador).toString());
            }
            if(contador%10000 == 0) System.out.println("contenido "+contador);
        }
        bwContenidos.close();
        bwGeneroContenidos.close();
        bwPeliculas.close();
        bwSeries.close();
        bwSuscripcionContenidos.close();
    }
}
