/**
 * Esta clase es una implementación de un digrafo usando matrices de adyacencia
 * 
 * @author Mauricio Toro, Isabel Urrego y Juliana Lalinde 
 * @version 1
 */
import java.util.*;
public class DigraphAM extends Graph {

    int[][] matriz;

    public DigraphAM(int size) {
        super(size);
        matriz = new int[size][size];        
    }

    public int getWeight(int source, int destination) {
        return matriz[source][destination];
    }

    public void addArc(int source, int destination, int weight) {
        matriz[source][destination]=weight;
    }

    public ArrayList<Integer> getSuccessors(int vertex) {
        ArrayList successors= new ArrayList<Integer>();
        for(int x=0; x<matriz[vertex].length; x++) {
            if(matriz[vertex][x]!=0){
                successors.add(x);
            }
        }
        return successors;
    }
}