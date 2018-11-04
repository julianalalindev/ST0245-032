/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkgfinal;

/**
 *
 * @author Isabel Urrego and Juliana Lalinde
 */
import java.io.*;
public class ProyectoFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File file;
        //file=new File("ConjuntoDeDatosCon1000000abejas.txt");
        //file=new File("ConjuntoDeDatosCon100000abejas.txt");
        //file=new File("ConjuntoDeDatosCon10000abejas.txt");
        //file=new File("ConjuntoDeDatosCon1000abejas.txt");
        //file=new File("ConjuntoDeDatosCon100abejas.txt");
        //file=new File("ConjuntoDeDatosCon10abejas.txt");
        file=new File("ConjuntoDeDatosCon4abejas.txt");
        Table ex = new Table(file);
    }
}
