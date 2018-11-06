package proyecto;
/**
 * Class bee 
 * @author Juliana Lalinde and Isabel Urrego
 */
public class Bee {
    
    private final double x;
    private final double y;
    private final double z;
    private final String coordinatesInDegrees;
    private double compValue;
    private boolean collides=false;
    
    /**
     * Constructor of object bee
     * @param x double that has the coordinate in x of the bee (meters)
     * @param y double that has the coordinate in y of the bee (meters)
     * @param z double that has the coordinate in z of the bee (meters)
     * @param coordinatesInDegrees  String that has the coordinate in y and z of the bee (degrees)
     */
    public Bee(double x, double y, double z, String coordinatesInDegrees) {
        this.x=x;
        this.y=y;
        this.z=z;
        this.coordinatesInDegrees=coordinatesInDegrees;
    }
    
    /**
     * Method to access to the coordinate in x of the bee
     * @return value of the coordinate in x
     */
    public double getX () {
        return x;
    }
    
    /**
     * Method to access to the coordinate in y of the bee
     * @return value of the coordinate in y
     */
    public double getY() {
        return y;
    }
    
    /**
     * Method to access to the coordinate in z of the bee
     * @return value of the coordinate in z
     */
    public double getZ() {
        return z;
    }
    
    /**
     * Method to access to the comparation value 
     * @return double with the comparation value
     */
    public double getCompValue() {
        return compValue;
    }
    
    /**
     * Method to set the comparation value
     * @param compValue double with the actual comparation value that is going to be changed
     */
    public void setCompValue (double compValue) {
        this.compValue=compValue;
    }
    
    /**
     * Method to know if the bee already collides
     * @return boolean true if the bee collides
     */
    public boolean getCollides() {
        return collides;
    }
    
    /**
     * Method to set the collision state of the bee
     * @param collides actual collision state 
     */
    public void setCollides (boolean collides) {
        this.collides=collides;
    }
    
    /**
     * Method to get the coordinates in degrees in y and z of a bee
     * @return String with the coordinates in y and z in degrees
     */
    public String getCoordinatesInDegrees() {
        return coordinatesInDegrees;
    }
}