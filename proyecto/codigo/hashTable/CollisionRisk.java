package proyectoh;
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
    
    private Bee[] bees;
    private ArrayList<Bee> matrix[][][];
    		
    private ArrayList<Bee> collisions;
    
    private double minX, minY, minZ, maxX, maxY, maxZ;
    
    public CollisionRisk (int numberOfBees) {
        this.numberOfBees=numberOfBees;
        start(new File("ConjuntoDeDatosCon"+numberOfBees+"abejas.txt"));
    }
    
    public final void start (File file) {
        bees=new Bee[numberOfBees];
        collisions=new ArrayList();
        readFile(file);
        long startTime = System.currentTimeMillis();
        buildMatrix();
        detectCollisions();
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("El algoritmo tomo un tiempo de: "+estimatedTime+" ms");
        writeFile();
    }
    
    private void readFile (File file) {
    	
    	maxX = -Double.MAX_VALUE;
    	maxY = -Double.MAX_VALUE;
    	maxZ = -Double.MAX_VALUE;
    	minX = Double.MAX_VALUE;
    	minY = Double.MAX_VALUE;
    	minZ = Double.MAX_VALUE;
        try{
            BufferedReader r = new BufferedReader(new FileReader(file));
            String bee=r.readLine();
            String[] coordinates;
            Bee n;
            for(int x=0;(bee=r.readLine())!=null; x++) {
                coordinates=bee.split(",");
                n=new Bee(Double.parseDouble(coordinates[0])*toMeters*Math.cos(Double.parseDouble(coordinates[1])),Double.parseDouble(coordinates[1])*toMeters,Double.parseDouble(coordinates[2]),coordinates[0]+","+coordinates[1]);
                if (n.getX() < minX) {
                	minX = n.getX();
                }
                if (n.getY() < minY) {
                	minY = n.getY();
                }
                if (n.getZ() < minZ) {
                	minZ = n.getZ();
                }
                if (n.getX() > maxX) {
                	maxX = n.getX();
                }
                if (n.getY() > maxY) {
                	maxY = n.getY();
                }
                if (n.getZ() > maxZ) {
                	maxZ = n.getZ();
                }
                bees[x]=n;
                
            }
            r.close();
        } catch (IOException e){
            System.out.println("There was a mistake reading the file");
        }
    }
    
    private void buildMatrix() {
    	double side = 100/Math.sqrt(3);
    	int xLength = (int)  Math.ceil((maxX - minX)/side);
    	int yLength = (int)  Math.ceil((maxY - minY)/side);
    	int zLength = (int)  Math.ceil((maxZ - minZ)/side);
    	matrix = new ArrayList[xLength][yLength][zLength];
    	for (int current = 0; current < bees.length; current++) {
    		int x = (int) Math.floor((bees[current].getX()-minX)/side);
    		int y = (int) Math.floor((bees[current].getY()-minY)/side);
    		int z = (int) Math.floor((bees[current].getZ()-minZ)/side);
    		if (matrix[x][y][z] == null) {
    			matrix[x][y][z] = new ArrayList<Bee>();
    		}
    		matrix[x][y][z].add(bees[current]);
    	}   	
    }
    
    private void detectCollisions() {
    	
    	for (int x = 0; x < matrix.length; x++) {
    		for (int y = 0; y < matrix[x].length; y++) {
    			for (int z = 0; z < matrix[x][y].length; z++) {
    				if ((matrix[x][y][z] != null) && (matrix[x][y][z].size() > 1)) {
    					for (int w = 0; w < matrix[x][y][z].size(); w++)
    						collisions.add(matrix[x][y][z].get(w));
    				} else if (matrix[x][y][z] != null){
    					boolean collision = false;
    					double x1 = matrix[x][y][z].get(0).getX();
    					double y1 = matrix[x][y][z].get(0).getY();
    					double z1 = matrix[x][y][z].get(0).getZ();
    					for (int deltaX = (x > 0 ? -1 : 0); deltaX <= (x<matrix.length-1 ? 1 : 0) && !collision; deltaX++) {
        					for (int deltaY = (y > 0 ? -1 : 0); deltaY <= (y<matrix[x].length-1 ? 1 : 0) && !collision; deltaY++) {
            					for (int deltaZ = (z > 0 ? -1 : 0); deltaZ <= (z<matrix[x][y].length-1 ? 1 : 0) && !collision; deltaZ++) {
            						if (deltaX != 0 || deltaY != 0 || deltaZ != 0) {
            							if (matrix[x+deltaX][y+deltaY][z+deltaZ] != null) {
            								for (int w = 0; w < matrix[x+deltaX][y+deltaY][z+deltaZ].size() && !collision; w++) {
            									double x2 = matrix[x+deltaX][y+deltaY][z+deltaZ].get(w).getX();
            									double y2 = matrix[x+deltaX][y+deltaY][z+deltaZ].get(w).getY();
            									double z2 = matrix[x+deltaX][y+deltaY][z+deltaZ].get(w).getZ();
            									if (Math.pow(x1-x2,2)+Math.pow(y1-y2,2)+Math.pow(z1-z2, 2) <= 10000) {
            										collision = true;
            									}
            								}
            							}
            						}
            					}
        					}
    					}
    					if (collision) {
    						collisions.add(matrix[x][y][z].get(0));    						
    					}
    				}
    			}
    		}
    	}
    }
        
    private void writeFile () {
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
