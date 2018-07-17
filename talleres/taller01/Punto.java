import java.util.*;

public class Punto {

    private double x, y;

  
    public Punto(double x, double y) {
        x= this.x;
        y= this.y;

    }


    public double x() {
        return x;
    }

  
    
    public double y() {
        return y;

    }

    
    public double radioPolar() {
        return Math.sqrt(Math.pow(x,2)+Math.pow(y,2));

    }


    
    public double anguloPolar() {
        return Math.atan2(y,x);
    }

   
  
    public double distanciaEuclidiana(Punto otro) {
        return Math.sqrt(Math.pow((x-x()),2)+Math.pow((y-y()),2));
    }
}