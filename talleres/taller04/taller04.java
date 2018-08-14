
/**
 * Write a description of class taller04 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class taller04
{
    public static void main(String[] args){
        for(int i=1; i<=20; i++){
            int[] a= new int[i];
            for(int j=1; j<i;j++){
                a[j]=j;
            }
            suma(a,0);
        }
    }
    //Punto1
   public static int suma(int[] array,int i){
        if(array.length==i){
            return 0;
        }else{
            return array[i] + suma(array,i+1);
        }
    }
    
    //Punto2
    public static boolean subgrupo(int start, int[] nums, int targ){
        if(start>= nums.length){
            return targ==0;
        }else{
            return subgrupo(start+1,nums,targ-nums[start]) || subgrupo(start+1,nums,targ);
        }
    }
}
