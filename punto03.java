
/**
 * Write a description of class punto2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.concurrent.TimeUnit; 
public class punto03
{
    public static void main(String[] args){
        for(int i=1;i<=20;i++){
            long start = System.currentTimeMillis();
            punto2(i);
            long fin = System.currentTimeMillis(); 

            System.out.println("Tiempo: "+ (fin-start));
            System.out.println("");
        }
    }

    public static void punto2(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n;j++){
                  try{
                    TimeUnit.SECONDS.sleep(1);
                }
                catch (Exception e){
                }
                int mult= j*i;
            }
          
        }
    }
}
