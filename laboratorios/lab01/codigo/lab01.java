
/**
 * Lab 1
 * Juliana Lalinde e Isabel Urrego
 * 30/07
 */
public class lab01 {

	//Exercise 1.1
        public static int fibonacci (int n){
         if(n==0 || n==1){
           return 1;
         } else {
           return fibonacci(n-1)+fibonacci(n-2);
    	 }
	}
	
	public static void main (String[] args) {
	 System.out.println("Fibonnaci(10): "+fibonacci(10));
	 System.out.println("Fibonnaci(20): "+fibonacci(20));
	 System.out.println("Fibonnaci(100): "+fibonacci(100));
	 System.out.println("Fibonnaci(1000): "+fibonacci(1000));
	}
 
	//Exercise 2.1
	public int triangle(int rows) {
 	 if(rows==0){
   	   return 0;
  	 } else {
           return rows+triangle(rows-1);
  	 }
	}

	public int sumDigits(int n) {
  	 if(n<10){
    	   return n;
  	 } else {
    	   return n%10+ sumDigits(n/10);
  	 }
	}

	public int powerN(int base, int n) {
  	 if(n==0){
    	   return 1;
  	 } else if(n==1) {
    	   return base;
  	 } else {
    	   return base* powerN(base,n-1);
  	 }
	}

	public String changePi(String str) {
    	 if (str.length() < 2){
      	   return str;
    	 } else if (str.substring(0, 2).equals("pi")){
      	   return "3.14" + changePi(str.substring(2));
    	 } else {
      	   return str.charAt(0) + changePi(str.substring(1));
    	 }
	}

	public String noX(String str) {
    	 if (str.length() == 0){
      	   return "";
    	 } else if (str.charAt(0)=='x'){
      	   return noX(str.substring(1));
    	 } else {
      	   return str.charAt(0)+noX(str.substring(1));
    	 }
	}
	
	//Exercise 2.2
	public boolean groupSum6(int start, int[] nums, int target) {
         if(start>=nums.length) {
           return target==0;
         } else if(nums[start]/6==1) {
           return groupSum6(start+1,nums,target-nums[start]);
         } else {
           return groupSum6(start+1,nums,target-nums[start]) || groupSum6(start+1,nums,target);
         }
        }
	
	public boolean groupNoAdj(int start, int[] nums, int target) {
         if(start>=nums.length) {
           return target==0;
         } else {
           return groupNoAdj(start+2,nums,target-nums[start]) || groupNoAdj(start+1,nums,target);
         }
        }
	
	public boolean groupSum5(int start, int[] nums, int target) {
  	 if(start>=nums.length) {
    	   return target==0;
  	 } else if(nums[start]%5==0) {
           if(start<nums.length-1 && nums[start+1]==1) {
             return groupSum5(start+2,nums,target-nums[start]);
           } else {
             return groupSum5(start+1,nums,target-nums[start]);
           }
         } else {
           return groupSum5(start+1,nums,target-nums[start]) || groupSum5(start+1,nums,target);
         }
        }
	
	public boolean splitArray(int[] nums) {
         return splitArrayAux(nums,0,0,0);
        }

        public boolean splitArrayAux(int[] nums, int start, int sum1, int sum2) {
         if(start>=nums.length) {
           return sum1==sum2;
         } else {
           return splitArrayAux(nums,start+1,sum1+nums[start],sum2) || splitArrayAux(nums,start+1,sum1,sum2+nums[start]);
         }
        }
	
        public boolean splitOdd10(int[] nums) {
         return splitOdd10Aux(nums,0,0,0);
        }

        public boolean splitOdd10Aux(int[] nums, int start, int sum1, int sum2) {
         if(start>=nums.length) {
           return (sum1%10==0 && sum2%2!=0);
         } else {
           return splitOdd10Aux(nums,start+1,sum1+nums[start],sum2) || splitOdd10Aux(nums,start+1,sum1,sum2+nums[start]);
         }
        }
}
