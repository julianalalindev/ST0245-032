import java.util.*;

/**
 *
 * @author Isabel Urrego and Juliana Lalinde
 * @version 1.0
 */
public class Punto1 {
    
    public static void main (String[] args) {
        //1.2 test
        List lista = new ArrayList();
        lista.add(10);
        lista.add(2);
        lista.add(4);
        lista.add(8);
        pivot(lista);
    }
    
    //1.1  with LinkedList
    public static void SmartInsert(LinkedList one, int data){
        if(one.contains(data)){
        }else{
            one.add(data);
        }

    }
    //1.1 with ArrayList
    public static void SmartInsert(ArrayList one, int data){
        if(one.contains(data)){
        }else{
            one.add(data);
        }

    }

   //1.2 with only one loop
    public static int pivot (List<Integer> lista) {
        Iterator<Integer> t = lista.iterator();
        Iterator<Integer> p = lista.iterator();
        int pivote=1;
        int si=p.next();
        int actual = p.next();
        int siguiente = p.next();
        int sd=t.next()+t.next()+t.next();
        sd -= si + actual;
        while (t.hasNext()) {         
            sd+=t.next();
            int dif1 = sd - si;
            int dif2 = sd - siguiente - si - actual;
            if (Math.abs(dif1) > Math.abs(dif2)) {
                si += actual;
                sd -= siguiente;
                pivote++;
                actual = siguiente;
                siguiente = p.next();
            }
        }
        System.out.println("The pivot should be located in position "+pivote);
        return pivote;
    }
}
