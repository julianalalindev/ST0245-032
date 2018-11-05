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
    private LinkedList<Bee>[][][] table;
    //Matriz dimensions
    private int dimX;
    private int dimY;
    private int dimZ;
    //Collisions
    private LinkedList<Bee> collision;
    //casos de abejas solas
    private int[][][] table1;
    private LinkedList<int[]> toCheck;
    
    public Table (File file) {
        create(readFile(file));
    }
    /**
     * Reads the file given as a parameter and stores the bees in an array. 
     * @param file
     * @return 
     */
    private Bee[] readFile (File file) {
        Bee[] bees = new Bee[10000];
        try{
            BufferedReader r = new BufferedReader(new FileReader(file));
            String bee=r.readLine();
            String[] coordinates;
            for(int x=0; x<bee.length() && (bee=r.readLine())!=null; x++) {
                coordinates=bee.split(",");
                //Creates a new bee with all of the coordinates transformed to meters
                bees[x]=new Bee(Double.parseDouble(coordinates[0])*toMeters*Math.cos(Double.parseDouble(coordinates[1])),Double.parseDouble(coordinates[1])*toMeters,Double.parseDouble(coordinates[2]),coordinates[0]+","+coordinates[1]);
            }  
            System.out.println("Reading succesful");
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
            xMax= bees[0].getX();
            xMin= bees[0].getX();
            yMax= bees[0].getY();
            yMin= bees[0].getY();
            zMax= bees[0].getZ();
            zMin= bees[0].getZ();
          
        for(int x=1; x<bees.length && bees[x]!=null; x++) {
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
        System.out.println(xMax+" "+yMax+" "+zMax);
        System.out.println(xMin+" "+yMin+" "+zMin);
        System.out.println(dimX+" "+dimY+" "+dimZ);
        table= new LinkedList[dimX][dimY][dimZ];
        table1 = new int[dimX][dimY][dimZ];
        collision=new LinkedList();
        toCheck= new LinkedList();
        for(int x=0; x<bees.length && bees[x]!=null; x++) {
            System.out.println("Hi");
            keys=hashFunction(bees[x]);
            System.out.println("Hashing succesful");
            if(table[keys[0]][keys[1]][keys[2]]==null){
                table[keys[0]][keys[1]][keys[2]]= new LinkedList();
            }
            table[keys[0]][keys[1]][keys[2]].add(bees[x]);
            
            if((table1[keys[0]][keys[1]][keys[2]])==0){
                    toCheck.add(keys);
                    table1[keys[0]][keys[1]][keys[2]]=1;
                    
            }else if((table1[keys[0]][keys[1]][keys[2]])==1){
                
                toCheck.remove(keys);
                collision.addAll(table[keys[0]][keys[1]][keys[2]]);
                table1[keys[0]][keys[1]][keys[2]]=2;
                
            }
            else{
                collision.add(bees[x]);
              }
            
        }
        System.out.println("Creating succesful");
        checkAdjacent();
        System.out.println("checked");
        writeFile();
        System.out.println("cwritten");
    }
    /**
     * 
     * @param bee
     * @return 
     */
    private int[] hashFunction (Bee bee) {
        int[] keys=new int[3];
        keys[0]=(int)Math.floor((bee.getX()-xMin)/side);
        
        System.out.println(keys[0]);
        keys[1]=(int)Math.floor((bee.getY()-yMin)/side);
       System.out.println(keys[1]);
        keys[2]=(int)Math.floor((bee.getZ()-zMin)/side);
        System.out.println(keys[2]);
        return keys;
    }
    /**
     * 
     */
    
    
    public void checkAdjacent() {
        while(toCheck.size()!=0){
         boolean check=false;
         int[] e = toCheck.pollFirst();
         Bee element= table[e[0]][e[1]][e[2]].getFirst();
          //Each one loop checks in one adjacent
          
          //1
          while(e[0]<5 && table[e[0]+1][e[1]][e[2]]!= null ){
              LinkedList<Bee> bees=table[e[0]+1][e[1]][e[2]];
              Bee bee2= bees.pollFirst();
              if(Math.sqrt((bee2.getX()-element.getX())*(bee2.getX()-element.getX())+(bee2.getY()-element.getY())*(bee2.getY()-element.getY())+(bee2.getZ()-element.getZ())*(bee2.getZ()-element.getZ()))<=100){
                  collision.add(element);
                  check=true;
                  break;
                  
              }
          }
          if(check=true){
              check= false;
              continue;
              
          }
          
          //2
          while(e[0]>0 && table[e[0]-1][e[1]][e[2]]!= null ){
              LinkedList<Bee> bees=table[e[0]+1][e[1]][e[2]];
              Bee bee2= bees.pollFirst();
              if(Math.sqrt((bee2.getX()-element.getX())*(bee2.getX()-element.getX())+(bee2.getY()-element.getY())*(bee2.getY()-element.getY())+(bee2.getZ()-element.getZ())*(bee2.getZ()-element.getZ()))<=100){
                  collision.add(element);
                  check=true;
                  break;
                  
              }
          }
          if(check=true){
              check= false;
              continue;
              
          }
          
          //3
          while(e[1]<5 && table[e[0]][e[1]+1][e[2]]!= null ){
              LinkedList<Bee> bees=table[e[0]+1][e[1]][e[2]];
              Bee bee2= bees.pollFirst();
              if(Math.sqrt((bee2.getX()-element.getX())*(bee2.getX()-element.getX())+(bee2.getY()-element.getY())*(bee2.getY()-element.getY())+(bee2.getZ()-element.getZ())*(bee2.getZ()-element.getZ()))<=100){
                  collision.add(element);
                  check=true;
                  break;
                  
              }
          }
          if(check=true){
              check= false;
              continue;
              
          }
          
          
          //4
          while(e[1]>0 && table[e[0]][e[1]-1][e[2]]!= null ){
              LinkedList<Bee> bees=table[e[0]+1][e[1]][e[2]];
              Bee bee2= bees.pollFirst();
              if(Math.sqrt((bee2.getX()-element.getX())*(bee2.getX()-element.getX())+(bee2.getY()-element.getY())*(bee2.getY()-element.getY())+(bee2.getZ()-element.getZ())*(bee2.getZ()-element.getZ()))<=100){
                  collision.add(element);
                  check=true;
                  break;
                  
              }
          }
          if(check=true){
              check= false;
              continue;
              
          }
          
          //5
          while(e[2]<5 && table[e[0]][e[1]][e[2]+1]!= null ){
              LinkedList<Bee> bees=table[e[0]+1][e[1]][e[2]];
              Bee bee2= bees.pollFirst();
              if(Math.sqrt((bee2.getX()-element.getX())*(bee2.getX()-element.getX())+(bee2.getY()-element.getY())*(bee2.getY()-element.getY())+(bee2.getZ()-element.getZ())*(bee2.getZ()-element.getZ()))<=100){
                  collision.add(element);
                  check=true;
                  break;
                  
              }
          }
          if(check=true){
              check= false;
              continue;
              
          }
          
          //6
          while(e[2]>0 && table[e[0]][e[1]][e[2]-1]!= null ){
              LinkedList<Bee> bees=table[e[0]+1][e[1]][e[2]];
              Bee bee2= bees.pollFirst();
              if(Math.sqrt((bee2.getX()-element.getX())*(bee2.getX()-element.getX())+(bee2.getY()-element.getY())*(bee2.getY()-element.getY())+(bee2.getZ()-element.getZ())*(bee2.getZ()-element.getZ()))<=100){
                  collision.add(element);
                  check=true;
                  break;
                  
              }
          }
          if(check=true){
              check= false;
              continue;
              
          }
          
          //7
          
        }
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
            writer.close();
        } catch (IOException e) {
            System.out.println("There was a problem writing the file that contains the bees in risk");
        }
    }
}