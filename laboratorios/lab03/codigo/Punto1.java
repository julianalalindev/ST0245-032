import java.util.*;

/**
 *
 * @author Isabel Urrego and Juliana Lalinde
 * @version 1.0
 */
public class Punto1 {
    
    public static void main (String[] args) {
        //1.2 test
        List list = new ArrayList();
        list.add(10);
        list.add(2);
        list.add(4);
        list.add(8);
        pivot(list);
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
    public static int pivot (List<Integer> list) {
        Iterator<Integer> t = list.iterator();
        Iterator<Integer> p = list.iterator();
        int pivot=1;
        int si=p.next();
        int a = p.next();
        int s = p.next();
        int sd=t.next()+t.next()+t.next();
        sd -= si + a;
        int dif1 = sd - si;
        int dif2 = sd - s - si - a;
        while (t.hasNext() || ((Math.abs(dif1) >= Math.abs(dif2) && p.hasNext()))) {                    
            if (Math.abs(dif1) >= Math.abs(dif2)) {
                si += a;
                sd -= s;
                pivot++;
                a = s;
                s = p.next();
            } else {
                sd+=t.next();    
            }
            dif1 = sd - si;
            dif2 = sd - s - si - a;
        }
        System.out.println("The pivot should be located in position "+pivot);
        return pivot;
    }
    
    //1.3
    //Class to create fridge objects
    public class Fridge {
        private int code;
        private String description;

        public Fridge (int code, String description) {
            this.code=code;
            this.description=description;
        }

        public int getCode () {
            return code;
        }

        public String getDescription () {
            return description;
        }
    }
    //Class to create request objects
    public class Request {
        private int fridgesRequested;
        private String shop;

        public Request (int fridgesRequested, String shop) {
            this.fridgesRequested=fridgesRequested;
            this.shop=shop;
        }

        public int getFridgesRequested () {
            return fridgesRequested;
        }

        public String getShop () {
            return shop;
        }
    }
    
    //Implementation
    public static void fridges (Stack<Fridge> fridges, Queue<Request> requests) {
        while(requests.peek()!=null) {
            Request new=requests.poll();
            int nev=new.getFridgesRequested();
            System.out.print(new.getShop()+":");
            while(fridges.size()!=0 && nev!=0) {
                Fridge aux=fridges.pop();
                System.out.print(" ("+aux.getCode()+" , "+aux.getDescription()+")");
                nev--;
            }
            if(requests.peek()!=null && fridges.size()==0) {
                System.out.print("There are no more fridges available");
            }
            System.out.println();
        }
    }
}
