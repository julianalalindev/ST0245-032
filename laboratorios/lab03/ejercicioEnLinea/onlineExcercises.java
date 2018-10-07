import java.util.*;
/**
 * Write a description of class onlineExcercises here.
 *
 * @author Juliana Lalinde e Isabel Urrego
 * @version 1.0
 */
public class onlineExcercises
{
    //Excercie 2.1
     public static void texto(){
        Scanner sc = new Scanner(System.in);
       
        while(sc.hasNextLine()){
             String s= sc.nextLine();
            LinkedList<Character> list= new LinkedList<>();
            for(int i=0; i<s.length();i++){
                int index=0;
                if(s.charAt(i)=='['){
                    index=0;
                }else if(s.charAt(i)==']'){
                    index=list.size();
                }else{
                    list.add(index++,s.charAt(i));
                }
            }

            //Para imprimir
            LinkedList<Character> aux=new LinkedList<>();
            while(list!=null){
                aux.add(list.remove());
            }
            while(aux!=null){
                System.out.println(aux.remove());
            }
        }

    }
    
}
