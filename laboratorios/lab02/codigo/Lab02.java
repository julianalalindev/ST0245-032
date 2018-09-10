
/**
 *
 * @author Isabel Urrego y Juliana Lalinde
 */
public class Lab02 {
    
    //Insertion sort  
    public static int[] orden(int[] num) {
       for(int x=1; x<num.length; x++) { 
           for(int y=x-1; y>=0; y--) {
               if(num[x]<num[y]) {
                   int num2=num[x];
                   num[x]=num[y];
                   num[y]=num2;
                   x--;
               }
           }
        }
       return num;
   }
   
    //Array 2

    //countEvens
    public int countEvens(int[] nums) {
        int even=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                even++;
            }

        }
        return even;
    }

    //bigDiff
    public int bigDiff(int[] nums){
        int min=nums[0];
        int max=nums[0];
        if(nums.length>0){
            for(int i=0;i<nums.length;i++){
                max= Math.max(max,nums[i]);
                min=Math.min(min,nums[i]);
            }
        }
        return max-min;

    }

    //centeredAverage
    public int centeredAverage(int[] nums) {
        int min=nums[0];
        int max=nums[0];
        int sum=0;
        if(nums.length>0){
            for(int i=0;i<nums.length;i++){
                sum+=nums[i];
                max= Math.max(max,nums[i]);
                min=Math.min(min,nums[i]);
            }
        }
        return (sum-max-min)/(nums.length-2);
    }

    //sum13
    public int sum13(int[] nums) {
        int sum=0;
        if(nums.length==0){
            return 0;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==13){
                i++;
            }else{
                sum+=nums[i];
            }
        }
        return sum;
    }

    //has22
    public boolean has22(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==2 && nums[i+1]==2){
                return true;
            }
        }
        return false;
    }
    
    //Array 3
    
    //maxSpan
    public int maxSpan(int[] nums) {
        int mayor=0;
        int comparar=0;
        for(int x=0; x<nums.length; x++) {
            for (int y=0; y<nums.length; y++) {
                if(nums[x]==nums[y]) {
                    comparar=y-x+1;
                }
            }
            if(comparar>mayor) {
                mayor=comparar;
            }
        }
        return mayor;
    }
    
    //fix34
    public int[] fix34(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 3) {
                int temp = nums[i + 1];
                nums[i + 1] = 4;
                for (int j = i + 2; j < nums.length; j++) {
                    if (nums[j] == 4) { 
                        nums[j] = temp;
                    }
                }
            }
        }
        return nums;
    }
    
    //fix54
    public int[] fix45(int[] nums) {
        for (int x = 0; x < nums.length; x++) {
            if (nums[x] == 4) {
                for (int y = 0; y < nums.length; y++) {
                    if (nums[y] == 5) {
                        if (y > 0 && nums[y-1] != 4) {
                            int temp = nums[x+1];
                            nums[x+1] = 5;
                            nums[y] = temp;
                        } else if (y == 0) {
                            int temp = nums[x+1];
                            nums[x+1] = 5;
                            nums[y] = temp;
                        }
                    }
                }
            }
        }
        return nums;
    }
    
    //linearIn
    public boolean linearIn(int[] outer, int[] inner) {
        int numFound = 0;
        if(inner.length == 0) {
            return true;
        }
        int i = 0;
        for(int x = 0; x < outer.length; x++) {
            if(outer[x] == inner[i]) {
                numFound++;
                i++;
            } else if(outer[x] > inner[i]) {
                return false;
            }
            if(numFound == inner.length) {
                return true;
            }
        }
        return false;
    }

    
    //seriesUp
    public int[] seriesUp(int n) {
        int[] nuevo = new int[n * (n + 1) / 2];
        int i = 0;
        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= x; y++) {
                nuevo[i++] = y;
            }
        }
        return nuevo;
    }
}
