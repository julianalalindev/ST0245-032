/**
/ Title: MergeSort source code>
 Author: cocodrips
 Date: 2013
 Code version: 1.0
 Availability: https://gist.github.com/cocodrips/5937371https://gist.github.com/cocodrips/5937371
**/
import java.util.Random;
import java.util.concurrent.TimeUnit; 
public class Mergesort {

    private static double[] merge(double[] a, double[] b) {
        double[] c = new double[a.length + b.length];
        int i = 0, j = 0;
        for (int k = 0; k < c.length; k++) {
            if      (i >= a.length) c[k] = b[j++];
            else if (j >= b.length) c[k] = a[i++];
            else if (a[i] <= b[j])  c[k] = a[i++];
            else                    c[k] = b[j++];
            try{
                    TimeUnit.SECONDS.sleep(1);
                }
                catch (Exception e){
                }
        }
        return c;
    }

    public static double[] mergesort(double[] input) {
        int N = input.length;
        if (N <= 1) return input;
        double[] a = new double[N/2];
        double[] b = new double[N - N/2];
        for (int i = 0; i < a.length; i++)
            a[i] = input[i];
        for (int i = 0; i < b.length; i++)
            b[i] = input[i + N/2];
        return merge(mergesort(a), mergesort(b));
    }

    private static boolean isSorted(double[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i] < a[i-1]) return false;
        return true;
    }


    // Main method by Juliana and Isabel
    public static void main(String[] args) {
        

        for(int j=1;j<=20;j++){
            double[] a = new double[j];
            for (int i = 0; i < a.length; i++){
                a[i] = j-i;
                //System.out.print(a[i]+" ");
            }
            //System.out.println();
            long start = System.currentTimeMillis();
            a = mergesort(a);
            long fin = System.currentTimeMillis(); 
            System.out.println(fin-start);
            //for (int i = 0; i < a.length; i++){
                //System.out.print(a[i]+" ");
            //}

            //System.out.println(isSorted(a));

        }

    }
}
