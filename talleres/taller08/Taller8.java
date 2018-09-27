import java.util.*;

/**
 * @author Mauricio Toro, Andrés Páez ,Juliana Lalinde e Isabel Urrego
 */
public class Taller8 {
    //Punto opcional 1
    public static Stack<Integer> inversa (Stack<Integer> stack){
        Stack<Integer> in =new Stack<Integer>();
        for(int i=0; i<stack.size();i++){
            in.push(stack.pop());
        }
        return in; 
    }

    //Punto opcional 2
    public static void cola (Queue<String> queue){
        Queue<String> ord= new LinkedList<String>();
        while(queue.peek()!= null){
            ord.add(queue.poll());
        }
        while(ord.peek()!= null){
            System.out.println("Atendiendo a "+ord.poll());

        }
    }

    //Tomado de Internet
    public static boolean isInteger(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    //Punto 1
    public static int polaca  (String string){
        String[] s= string.split(" ");
        Stack<String> aux= new Stack<String>();
        String temp;
        int num=0;
        for(int i=0; i<s.length; i++){
            temp=s[s.length-1-i];
            if(isInteger(temp)){
                aux.push(temp);
            }else{
                if(temp.equals("+")){
                    num= Integer.parseInt(aux.pop())+ Integer.parseInt(aux.pop());
                }
                if(temp.equals("-")){
                    num= -(Integer.parseInt(aux.pop())- Integer.parseInt(aux.pop()));
                }
                if(temp.equals("*")){
                    num= Integer.parseInt(aux.pop())* Integer.parseInt(aux.pop());
                }
                if(temp.equals("/")){
                    num= Integer.parseInt(aux.pop())/ Integer.parseInt(aux.pop());
                }
                if(temp.equals("%")){
                    num= Integer.parseInt(aux.pop())% Integer.parseInt(aux.pop());
                }
            }
        }
        return num;
    }
}