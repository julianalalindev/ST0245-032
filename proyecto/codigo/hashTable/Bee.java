package proyectoh;
/**
 * Class bee for Hash Table
 * @author Juliana Lalinde and Isabel Urrego
 */
public class Bee {
    
    private final double x;
    private final double y;
    private final double z;
    private final String coordinatesInDegrees;
    /**
     *  Constructor of bees
     * @param x coordinate of the bee in x (Meters)
     * @param y coordinate of the bee in y (Meters)
     * @param z coordinate of the bee in z (Meters)
     * @param coordinatesInDegrees  coordinate of the bee in y and z (Degrees)
     */
    public Bee(double x, double y, double z, String coordinatesInDegrees) {
        this.x=x;
        this.y=y;
        this.z=z;
        this.coordinatesInDegrees=coordinatesInDegrees;
    }
    
    /**
     * Accesor
     * @return a double with the coordinate in x of the bee
     */
    public double getX () {
        return x;
    }
    
    /**
     * accesor
     * @return a double with the coordinate in y of the bee
     */
    public double getY() {
        return y;
    }
    
    /**
     * Accesor
     * @return a double with the coordinate in z of the bee
     */
    public double getZ() {
        return z;
    }
        /**
         * Accesor
         * @return a String with the coordinates in y and z in degrees
         */
    public String getCoordinatesInDegrees() {
        return coordinatesInDegrees;
    }
}