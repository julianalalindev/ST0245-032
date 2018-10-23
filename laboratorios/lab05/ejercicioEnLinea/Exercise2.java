/**
 *
 * @author Isabel Urrego and Juliana Lalinde
 * @version 22/10/2018
 */
import java.util.*;
public class Exercise2 {

    public static void main (String [] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Insert the number of nodes in your graph (taking into account the existance of a node zero): ");
        int nodes=in.nextInt();
        int[][] graph=new int[nodes][nodes];
        System.out.print("Insert the number of edges in your graph: ");
        int edges=in.nextInt();
        System.out.println("Insert the two nodes that are part of an edge separately");
        int origin;
        int destiny;
        for(int x=1; x<=edges; x++) {
            System.out.println("Edge "+x);
            System.out.print("Origin: ");
            origin=in.nextInt();
            System.out.print("Destiny: ");
            destiny=in.nextInt();
            graph[destiny][origin]=1;
            graph[origin][destiny]=1;
        }
        if (bipartiteGraph(graph,nodes)) {
            System.out.println("BICOLORABLE");
        } else {
            System.out.println("NOT BICOLORABLE");
        }
    }

    public static boolean bipartiteGraph (int[][] graph,int nodes) { 
        int colors[]=new int[nodes]; 
        for (int i=0; i<nodes; ++i) {
            colors[i]=-1; 
        }    
        colors[0]=1; 
        Queue<Integer> numbers=new LinkedList<Integer>();
        numbers.add(0);
        while (numbers.size()!=0) { 
            int check=numbers.poll(); 
            if (graph[check][check]==1) {
                return false;  
            }
            for (int x=0; x<nodes; ++x) { 
                if (graph[check][x]==1 && colors[x]==-1) { 
                    colors[x]=1-colors[check]; 
                    numbers.add(x); 
                } else if (graph[check][x]==1 && colors[x]==colors[check]) {
                    return false; 
                }
            } 
        }  
        return true; 
    }  
}
