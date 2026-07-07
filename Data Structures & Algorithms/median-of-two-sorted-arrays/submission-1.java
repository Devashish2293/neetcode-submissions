class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if(length2<length1)
           return findMedianSortedArrays(nums2,nums1);
        int low = 0 , high = length1;
        int left = (length1 +length2 +1)/2;
        while(low<=high)
        {
            int mid1 = (low + high) >> 1;
            int mid2 = left - mid1;
            int leftT = Integer.MIN_VALUE , leftB = Integer.MIN_VALUE;
            int rightT= Integer.MAX_VALUE , rightB = Integer.MAX_VALUE;
            if(mid1 < length1)
                rightT = nums1[mid1];
            if(mid2< length2)
                rightB = nums2[mid2];
            if(mid1 - 1 >= 0)
                leftT = nums1[mid1-1];
            if(mid2 - 1 >= 0)
                leftB = nums2[mid2 - 1];
            if(leftT <= rightB && leftB <= rightT){
                if((length1+length2)%2 == 1)
                    return Math.max(leftT,leftB);
                    return (Math.max(leftT, leftB) + Math.min(rightT, rightB)) / 2.0;
            }    
            else if(leftT>rightB)
                high = mid1-1;
            else
                low = mid1 + 1;
        }
        return 0;

    }
}
