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
    
    //1.3
    //Class to create fridge objects
    public class Nevera {
        private int codigo;
        private String descripcion;

        public Nevera (int codigo, String descripcion) {
            this.codigo=codigo;
            this.descripcion=descripcion;
        }

        public int getCodigo () {
            return codigo;
        }

        public String getDescripcion () {
            return descripcion;
        }
    }
    //Class to create request objects
    public class Solicitud {
        private int neverasSolicitadas;
        private String tienda;

        public Solicitud (int neverasSolicitadas, String tienda) {
            this.neverasSolicitadas=neverasSolicitadas;
            this.tienda=tienda;
        }

        public int getNeverasSolicitadas () {
            return neverasSolicitadas;
        }

        public String getTienda () {
            return tienda;
        }
    }
    
    public static void neveras (Stack<Nevera> neveras, Queue<Solicitud> solicitudes) {
        while(solicitudes.peek()!=null) {
            Solicitud nueva=solicitudes.poll();
            int nev=nueva.getNeverasSolicitadas();
            System.out.print(nueva.getTienda()+":");
            while(neveras.size()!=0 && nev!=0) {
                Nevera aux=neveras.pop();
                System.out.print(" ("+aux.getCodigo()+" , "+aux.getDescripcion()+")");
                nev--;
            }
            if(solicitudes.peek()!=null && neveras.size()==0) {
                System.out.print("No hay más neveras disponibles");
            }
            System.out.println();
        }
    }
}
