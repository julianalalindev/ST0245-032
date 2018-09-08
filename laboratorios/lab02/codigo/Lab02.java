
/**
 * Write a description of class Lab02 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lab02
{
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

    //centeredAvarage
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

}
