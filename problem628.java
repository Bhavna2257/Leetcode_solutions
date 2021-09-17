Approach 1:
-----------
Time Complexity: O(n logn)
Space Complexity: O(log n)

class Solution {
    public int maximumProduct(int[] nums) {
           Arrays.sort(nums); 
           int n = nums.length;
           int prod1 = nums[0] * nums[1] * nums[n - 1];
           int prod2 = nums[n - 1] * nums[n - 2] * nums[n - 3];
           return Math.max(prod1 , prod2);
           }
}

Approach 2:
-----------
Time Complexity: O(n)
Space Complexity: O(1)

class Solution {
    public int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] <= min1) {
                min2 = min1;
                min1 = nums[i];
            } else if(nums[i] <= min2) {
                min2 = nums[i];
            }
            if(nums[i] >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if(nums[i] >= max2) {
                max3 = max2;
                max2 = nums[i];
            } else if(nums[i] >= max3) {
                max3 = nums[i];
            }
            
        }
        int prod1 = min2 * min1 * max1;
        int prod2 = max1 * max2 * max3;
        
        return Math.max(prod1 , prod2);
        }
}
