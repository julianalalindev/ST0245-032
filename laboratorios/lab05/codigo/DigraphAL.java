import java.util.ArrayList;
import java.util.LinkedList;
/**
 * Esta clase es una implementación de un digrafo usando listas de adyacencia
 * 
 * @author Mauricio Toro 
 * @version 1
 */
public class DigraphAL extends Graph
{
   ArrayList<LinkedList<Pair>> list = new ArrayList<>();
   
   
   public DigraphAL(int size)
   {
       super(size);
       for(int i=0; i<size;i++){
            list.add(new LinkedList());
        }
   }
   
   public void addArc(int source, int destination, int weight)
   {
     Pair p= new Pair(destination,weight);
     list.get(source).add(p); 
   }
   
   public int getWeight(int source, int destination)
   {
       LinkedList<Pair> sou= list.get(source);
      for(int i=0;i<list.get(source).size();i++){
          if(sou.get(i).vertex == destination){
                return sou.get(i).weight;
            }
        }
        return 0;
   }
  
   //Method by Santiago Isaza and Hamilton Gomez
   public ArrayList<Integer> getSuccessors(int vertice)
   {
       ArrayList<Integer> successors= new ArrayList<>();
       LinkedList<Pair> sou= list.get(vertice);
       for(int y=0;y< sou.size();y++){
           if(sou.get(y).weight != 0){
               successors.add(list.get(vertice).get(y).vertex);
            }
        }
        return successors;
   }
}