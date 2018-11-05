package proyecto;
/**
 *
 * @author Juliana Lalinde and Isabel Urrego
 */
public class Bee {
    
    private final double x;
    private final double y;
    private final double z;
    private final String coordinatesInDegrees;
    private double compValue;
    private boolean collides=false;
    
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
    
    public double getCompValue() {
        return compValue;
    }
    
    public void setCompValue (double compValue) {
        this.compValue=compValue;
    }
    
    public boolean getCollides() {
        return collides;
    }
    
    public void setCollides (boolean collides) {
        this.collides=collides;
    }
    
    public String getCoordinatesInDegrees() {
        return coordinatesInDegrees;
    }
}
