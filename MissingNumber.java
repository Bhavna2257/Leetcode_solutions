/*
 * Leetcode problem 268
 * 
 */

class Solution {
    public int missingNumber(int[] nums) {
        
        int n = nums.length;
      
      Approach 1:
      -----------
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < n;i++){
            map.put(nums[i],1);
        }
        while(n >= 0){
            if(map.containsKey(n))
            {
            if(map.get(n) == 1)
            {
                
                --n;
                continue;
            }
            }
            else
                return n;
        }
        return 0;
      
      Approach 2:
      -----------
        /*
         * Calculate the sum of first 'n' natural numbers.
         * Calculate the sum of given array elements.
         * Calculate the difference between the two sums.
         * The obtained result will be the missing number.
         * Time complexity = O(n)
         * Space complexity = O(1) 
         */
        int sum = n*(n+1)/2;
        int arrSum = 0;
        for(int i = 0;i < nums.length;i++){
            arrSum += nums[i];
        }
        return sum - arrSum;
       
    }
}
