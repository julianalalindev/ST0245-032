
/**
 * Exercise 2.2
 *
 * @author Mauricio Toro, Juliana Lalinde e Isabel Urrego
 * @version 15/10/2018
 */
public class treeSumming
{
    public static boolean treeSumming(Node a, int sum) {
        if (a == null) {
            return false; 
        }else{
            if (a.left == null && a.right == null) {
                return sum == a.data; 
            }else {
                return treeSumming(a.left, sum- a.data)  || treeSumming(a.right, sum-a.data); 
            }
        }
    }
}
