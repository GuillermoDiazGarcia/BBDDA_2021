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
        rellenarGeneros();
        System.out.println("End Generos, start Contenidos");
        rellenarContenidos();
        System.out.println("Finish");
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
        for(contador=0;contador<numContenidos;contador++){
            bwContenidos.write(new Contenido(contador,"titulo"+contador,
                    LocalDate.of(1950+rand.nextInt(70), 1+rand.nextInt(11),
                    1+rand.nextInt(27)),1+rand.nextInt(9)).toString());
            num_generos = 1 + rand.nextInt(5);
            generosContenido = new int[num_generos];
            for(int i=0;i<num_generos;i++){         //Comprueba que el género no esté repetido para ese contenido
                nuevoGenero = rand.nextInt(19);
                checker = false;
                for(int j=0;j<=i;j++){
                    if(generosContenido[j]==nuevoGenero) checker = true;
                }
                if(!checker) bwGeneroContenidos.write(new Genero_Contenidos(rand.nextInt(19),contador).toString());
                else i--;                           //Si ese género ya estaba añadido para ese contenido no se añade y se repite el proceso
            }
            switch(rand.nextInt(1)){
                case 0:         //Peliculas
                    bwPeliculas.write(new Pelicula(80+rand.nextInt(40),contador).toString());
                case 1:         //Series
                    bwSeries.write(new Serie(10+rand.nextInt(20),1+rand.nextInt(14),contador).toString());
            }
            if(contador%10000 == 0) System.out.println("contenido "+contador);
        }
        bwContenidos.close();
        bwGeneroContenidos.close();
        bwPeliculas.close();
        bwSeries.close();
    }
}
