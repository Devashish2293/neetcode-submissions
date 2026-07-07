class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = findMax(piles);
        while(left<right)
        {
            int mid = left + (right-left)/2;
            int totalHours = findTotalHours(piles,mid);
            if(totalHours<=h)
            {
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
    public int findTotalHours(int[] arr,int rate)
    {
        double totalHours=0;
        for(int i = 0; i<arr.length ; i++)
        {
            totalHours += Math.ceil((double)arr[i]/rate);
        }
        return (int)totalHours;
    }

    public int findMax(int arr[])
    {
        int max = arr[0];
        for(int i = 1; i<arr.length ; i++)
        {
            if(max < arr[i])
                max=arr[i];
        }
        return max;

    }
}
