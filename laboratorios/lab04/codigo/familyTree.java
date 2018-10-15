
/**
 * Write a description of class family here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class familyTree
{
    public static void main(String[] args){
        Node me= new Node("Isabel");
        Node dad= new Node("Hector");
        me.right= dad;
        Node mom= new Node("Piedad");
        me.left= mom;;
        
        //Grand Parents
        Node gma=new Node("Maria del Rosario");
        Node gpa= new Node("Felipe");
        mom.right= gpa;
        mom.left= gma;
        Node gmap= new Node("Clara");
        Node gpap= new Node("Mariano");
        dad.right= gpap;
        dad.left= gmap;
        
        //Great Grand Parents
        //Dad
        Node ggmap1= new Node("Julia");
        Node ggmap2= new Node("Carmen Rosa");
        Node ggpap1= new Node("Jesús");
        Node ggpap2= new Node("Nepomuceno");
        
        gpap.right= ggpap1;
        gpap.left=ggmap1;
        gmap.right= ggpap2;
        gmap.left = ggmap2;
        
        //Mom
        Node ggma1= new Node("Mercedes");
        Node ggma2= new Node("Lucrecia");
        Node ggpa1= new Node("Felipe");
        Node ggpa2= new Node("Julio");
        
        gpa.right= ggpa1;
        gpa.left=ggma1;
        gma.right= ggpa2;
        gma.left = ggma2;
    }
}
