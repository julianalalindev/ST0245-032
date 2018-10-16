/**
 * Esta clase es una implementación de un digrafo usando listas de adyacencia
 * 
 * @author Mauricio Toro 
 * @version 1
 */
import java.util.*;
public class DigraphAL extends Graph {

    //ArrayList<LinkedList<Pareja<Integer,Integer>>> grafoConListas;

    public DigraphAL(int size) {
        super(size);
        //grafoConListas=new ArrayList(size);
        for(int x=0; x<size; x++) {

        }
    }

    public void addArc(int source, int destination, int weight) {

    }

    public int getWeight(int source, int destination) {
        return 0;
    }

    public ArrayList<Integer> getSuccessors(int vertex) {
        ArrayList successors= new ArrayList<Integer>();
        return successors;
    }
}
