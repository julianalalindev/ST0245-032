/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkgfinal;

/**
 *
 * @author Isabel Urrego and Juliana Lalinde
 */
public class Bee {
    private double x;
    private double y;
    private double z;
    private String coordinatesInDegrees;
    
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
