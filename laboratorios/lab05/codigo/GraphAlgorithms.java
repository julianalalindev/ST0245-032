
/**
 * 
 *
 * @author Juliana Lalinde e Isabel Urrego
 * 
 */
public class GraphAlgorithms
{
    public static int whoHasMoreSuccessors(Graph graph){
        int max=0;
        int maxVertex=0;
        for(int i=0; i< graph.size-1; i++){
            if(graph.getSuccessors(i).size()> max){
                max=graph.getSuccessors(i).size();
                maxVertex=i;
            }
        }
        return maxVertex;
    }
}
