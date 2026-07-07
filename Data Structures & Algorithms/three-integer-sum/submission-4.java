class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int left;
        int right;
        List<List<Integer>> res = new ArrayList<>();
    
        for(int i = 0 ; i < nums.length ; i++)
        {  
            if (i > 0 && nums[i] == nums[i - 1]) continue; 
           left = i+1;
           right = nums.length -1; 
           while(left<right){
                int target = -nums[i]; 
                if(nums[left] + nums[right]<target)
                        left++;
                else if(nums[left] + nums[right]>target)  
                        right--;   
                else
                {    
                        List<Integer> list = new ArrayList();
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);  

                        while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;   
                }  
                 
           } 
           
        }
        return res;
    }
}
