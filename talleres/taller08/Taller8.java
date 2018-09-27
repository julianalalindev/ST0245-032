import java.util.*;

/**
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Queue.html"> Ver más acerca de colas<a/>
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html"> Ver más acerca de pilas <a/> 
 * @author Mauricio Toro, Andrés Páez 
 */
public class Taller8 {

    /**
     * @param stack es una pila ya implementada que se crea en el test
     * Este método se encarga de poner la pila stack en orden inverso
     * Nota: recuerde que la funcion pop() no solo expulsa la última 
     * posición de una pila si no que tambien devuelve su valor.
     * @return una pila que haga el inverso de stack
     */
    public static Stack<Integer> inversa (Stack<Integer> stack){
        Stack<Integer> in =new Stack<Integer>();
        for(int i=0; i<stack.size();i++){
            in.push(stack.pop());
        }
        return in; 
    }

    /**
     * @param queue es una cola ya implementada que se crea en el test
     * Este método se encarga de atender a personas.
     * Nota: Se debe imprimir en consola a quién atiende y sacarlo de la cola
     * existe una función "pull" que hace el trabajo más fácil
     * 
     */
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

    /**
     * @param string es una cadena de texto que viene de este modo 3 4 5 * + o de esta manera 2 3 * 5 +
     * todo viene separado por espacios por lo que la funcion split.("") vendría muy bien para separarlos
     * Se intenta hacer el calculo por medio del metodo polaco posfijo
     * @return un entero resultado de la operación
     */
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