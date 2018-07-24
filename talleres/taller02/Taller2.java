
/**
 * Juliana Lalinde e Isabel Urrego
 */
public class Taller2
{
    //Punto 1
    public static int euclides(int m, int n){
        if(m<n){
            int temp=m;
            m=n;
            n=temp;
        }
        
        if(n==0){
            return m;
        }else{
            return euclides(m%n,n);
        }
    }
    
    //Punto 2
    public static boolean punto2(int start, int[] arr, int target){
        if(start>= arr.length){
            return target==0;
        }else{
            return punto2(start+1, arr, target) || punto2(start+1,arr,target-arr[start]);
        }
    }
    
    //punto3
    public static void combinacion(String base, String s){
        if(s.length()==0){
            System.out.println(base);
        }else{
            combinacion(base+s.charAt(0),s.substring(1));
            combinacion(base,s.substring(1));
        }
    }
    
    //adicional
    public static void permu(String s) {
       permuAux("", s);
    }
    
    private static void permuAux(String base, String s){
        if(s.length()==0){
            System.out.println(base);
        }else{
            for(int x=0; x<s.length(); x++) {
                permuAux(base+s.charAt(x),s.substring(0,x)+s.substring(x));
            }
        }
    }
}
