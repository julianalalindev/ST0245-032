package proyecto;
/**
 *
 * @author Juliana Lalinde and Isabel Urrego
 */
public class Proyecto {
    
    public static void main(String[] args) {
        int bees;
        bees=1000000;
        //bees=100000;
        //bees=10000;
        //bees=1000;
        //bees=100;
        //bees=10;
        //bees=4;
        long startTime = System.currentTimeMillis();
        CollisionRisk ex = new CollisionRisk(bees);
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("El algoritmo tomo un tiempo de: "+estimatedTime+" ms");
    }
    
    
}
