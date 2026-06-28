class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixArr = new int[nums.length];
        int[] suffixArr = new int[nums.length];
        int[] res = new int[nums.length] ; 
        prefixArr[0] = 1;
        suffixArr[nums.length-1] = 1;

        for(int i  = 1 ; i <nums.length ; i++)
        {   
            prefixArr[i] = nums[i-1] * prefixArr[i-1];
        }

        for(int i  = nums.length -2 ; i >= 0 ; i--)
        {
            suffixArr[i] = nums[i+1] * suffixArr[i+1];
        }

        for(int i = 0 ; i <=nums.length-1 ; i++)
        {   
            res[i] = suffixArr[i] * prefixArr[i];
        }
        return res;
    }
}  
