package proyectoh;
/**
 *
 * @author Juliana Lalinde and Isabel Urrego
 */
public class Bee {
    
    private final double x;
    private final double y;
    private final double z;
    private final String coordinatesInDegrees;
    
    public Bee(double x, double y, double z, String coordinatesInDegrees) {
        this.x=x;
        this.y=y;
        this.z=z;
        this.coordinatesInDegrees=coordinatesInDegrees;
    }
    
    public double getX () {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public double getZ() {
        return z;
    }
        
    public String getCoordinatesInDegrees() {
        return coordinatesInDegrees;
    }
}