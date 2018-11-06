package proyecto;
/**
 *
 * @author Juliana Lalinde and Isabel Urrego
 */
import java.util.*;
import java.io.*;
public class CollisionRisk {
    
    private final double toMeters=111111;
    
    private final int numberOfBees;
    
    private Comparator<Bee> comp;
    
    private Bee[] cordX;
            
    private PriorityQueue<Bee> cordY;
    private PriorityQueue<Bee> cordZ;
    
    private ArrayList<Bee> collisions;
    
    public CollisionRisk (int numberOfBees) {
        this.numberOfBees=numberOfBees;
        start(new File("ConjuntoDeDatosCon"+numberOfBees+"abejas.txt"));
    }
    
    public final void start (File file) {
        comp = new Comparator<Bee>() {
            @Override
            public int compare(Bee b1, Bee b2) {
                if(b1.getCompValue()<b2.getCompValue()) {
                    return -1;
                } else if (b1.getCompValue()>b2.getCompValue()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
        cordX=new Bee[numberOfBees];
        collisions=new ArrayList();
        cordY=new PriorityQueue(numberOfBees,comp);
        cordZ = new PriorityQueue(numberOfBees, comp);
        readFile(file);
        long startTime = System.currentTimeMillis();
        checkX();
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("El algoritmo tomo un tiempo de: "+estimatedTime+" ms");
        writeFile();
    }
    
    public void readFile (File file) {
        try{
            BufferedReader r = new BufferedReader(new FileReader(file));
            String bee=r.readLine();
            String[] coordinates;
            Bee n;
            for(int x=0;(bee=r.readLine())!=null; x++) {
                coordinates=bee.split(",");
                //Without cos
                n=new Bee(Double.parseDouble(coordinates[0])*toMeters,Double.parseDouble(coordinates[1])*toMeters,Double.parseDouble(coordinates[2]),coordinates[0]+","+coordinates[1]);
                //With cos
                //n=new Bee(Double.parseDouble(coordinates[0])*toMeters*Math.cos(Double.parseDouble(coordinates[1])),Double.parseDouble(coordinates[1])*toMeters,Double.parseDouble(coordinates[2]),coordinates[0]+","+coordinates[1]);
                n.setCompValue(n.getX());
                cordX[x]=n;
            }
        Arrays.sort(cordX, comp);
        } catch (IOException e){
            System.out.println("There was a mistake reading the file");
        }
    }
    
    public void checkX() {
        for(int first=0; first<cordX.length; first++) {
            for(int current=first+1; current<cordX.length; current++) {
                if(Math.abs(cordX[first].getX()-cordX[current].getX())<=100) {
                    cordX[current].setCompValue(Math.abs(cordX[first].getY()-cordX[current].getY()));
                    cordY.add(cordX[current]);
                } else {
                    checkY(cordX[first]);
                    cordY.clear();
                    break;
                }
            }
        }
    }

    public void checkY(Bee first) {
        Bee current;
        while(cordY.peek()!=null) {
            current=cordY.poll();
            if(Math.pow(first.getX()-current.getX(),2)+Math.pow(first.getY()-current.getY(),2)<=10000) {
                current.setCompValue(Math.abs(first.getZ()-current.getZ()));
                cordZ.add(current);
            }
        }
        checkZ(first);
        cordZ.clear();
    }
    
    public void checkZ(Bee first) {
        Bee current;
        while(cordZ.peek()!=null) {
            current=cordZ.poll();
            if(Math.pow(first.getX()-current.getX(),2)+Math.pow(first.getY()-current.getY(),2)+Math.pow(first.getZ()-current.getZ(),2)<=10000) {
                addCollision(first);
                addCollision(current);
            }
        }
    }
    
    public void addCollision (Bee bee) {
        if(!bee.getCollides()) {
            collisions.add(bee);
            bee.setCollides(true);
        }
    }
    
    public void writeFile () {
        File file=new File("CollisionRisk.txt");
        try{
            if(file.exists()) {
                file.delete();
            }
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            if(collisions.isEmpty()) {
                writer.write("There are no bees at risk");
            } else {
                writer.write("Bees in risk of collision within the "+numberOfBees+" bees given\n");
                for(int x=0; x<collisions.size(); x++) {
                    writer.write(collisions.get(x).getCoordinatesInDegrees()+","+collisions.get(x).getZ()+"\n");
                } 
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("There was a problem writing the file that contains the bees in risk");
        }
    }
}
