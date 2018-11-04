package proyecto.pkgfinal;
/**
 *
 * @author Isabel Urrego and Juliana Lalinde
 */
import java.io.*;
import java.util.*;
public class Table {
    private final double toMeters=111111;
    private final double side=57.74;
    //Max and min coordinates to create the table
    private double xMax;
    private double xMin;
    private double yMax;
    private double yMin;
    private double zMax;
    private double zMin;
    //Table
    private ArrayList<Bee>[][][] table;
    //Matriz dimensions
    private int dimX;
    private int dimY;
    private int dimZ;
    //Collisions
    private ArrayList<Bee> collision;
    
    public Table (File file) {
        create(readFile(file));
    }
    /**
     * Reads the file given as a parameter and stores the bees in an array. 
     * @param file
     * @return 
     */
    private Bee[] readFile (File file) {
        Bee[] bees = new Bee[1000000];
        try{
            BufferedReader r = new BufferedReader(new FileReader(file));
            String bee=r.readLine();
            String[] coordinates;
            for(int x=0; x<bee.length() && (bee=r.readLine())!=null; x++) {
                coordinates=bee.split(",");
                //Creates a new bee with all of the coordinates transformed to meters
                bees[x]=new Bee(Double.parseDouble(coordinates[0])*toMeters*Math.cos(Double.parseDouble(coordinates[1])),Double.parseDouble(coordinates[1])*toMeters,Double.parseDouble(coordinates[2]),coordinates[0]+","+coordinates[1]);
            }    
        } catch (IOException e){
            System.out.println("There was a mistake reading the file");
        }
        return bees;
    }
    /**
     * 
     * @param bees 
     */
    private void findMaxAndMin (Bee[] bees) {
        for(int x=0; x<bees.length && bees[x]!=null; x++) {
            //Coordinate x
            xMax=Math.max(xMax, bees[x].getX());
            xMin=Math.min(xMin, bees[x].getX());
            //Coordinate y
            yMax=Math.max(yMax, bees[x].getY());
            yMin=Math.min(yMin, bees[x].getY());
            //Coordinate z
            zMax=Math.max(zMax, bees[x].getZ());
            zMin=Math.min(zMin, bees[x].getZ());
        }
    }
    /**
     * 
     * @param bees 
     */
    public final void create (Bee[] bees) {
        findMaxAndMin(bees);
        int[] keys;
        dimX=(int)Math.ceil((xMax-xMin)/side);
        dimY=(int)Math.ceil((yMax-yMin)/side);
        dimZ=(int)Math.ceil((zMax-zMin)/side);
        table= new ArrayList[dimX][dimY][dimZ];
        for(int x=0; x<bees.length && bees[x]!=null; x++) {
            keys=hashFunction(bees[x]);
            table[keys[0]][keys[1]][keys[2]].add(bees[x]);
        }
    }
    /**
     * 
     * @param bee
     * @return 
     */
    private int[] hashFunction (Bee bee) {
        int[] keys=new int[3];
        keys[0]=(int)Math.ceil((bee.getX()-xMin)/side);
        keys[1]=(int)Math.ceil((bee.getY()-yMin)/side);
        keys[2]=(int)Math.ceil((bee.getZ()-zMin)/side);
        return keys;
    }
    /**
     * 
     */
    public void checkCollisions () {
        collision=new ArrayList();
        for(int x=0; x<dimX; x++) {
            for(int y=0; y<dimY; y++) {
                for(int z=0; z<dimZ; z++) {
                    if(table[x][y][z].size()>1) {
                        collision.addAll(table[x][y][z]);
                    } else if (table[x][y][z].size()==1) {
                        checkAdjacent();
                    }
                }
            }
        }
    }
    
    public void checkAdjacent() {
    
    }
    /**
     * 
     */
    public void writeFile () {
        File file=new File("CollisionRisk.txt");
        try{
            if(file.exists()) {
                file.delete();
            }
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            for(int x=0; x<collision.size(); x++) {
                writer.write(collision.get(x).getCoordinatesInDegrees()+","+collision.get(x).getZ());
            }
        } catch (IOException e) {
            System.out.println("There was a problem writing the file that contains the bees in risk");
        }
    }
}
