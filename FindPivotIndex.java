class Solution {
    public int pivotIndex(int[] nums) {
        
        int leftSum = 0;
        int rightSum = 0;
       
      Approach 1:
      -----------
      for(int i = 0;i < nums.length;i++)
        {
            rightSum = 0;
            if(i == 0)
                leftSum = 0;
            else
                leftSum += nums[i-1];
            for(int j = i + 1;j < nums.length;j++)
            {
                rightSum += nums[j];
            }
            if(leftSum == rightSum)
                return i;
        }
        return -1;
    }
    
  Approach 2:
  -----------
  int totalSum = 0;
        for(int i = 0;i < nums.length;i++)
        {
            totalSum += nums[i];
        }
         for(int i = 0;i < nums.length;i++)
        {
            if(i != 0) leftSum += nums[i - 1];
            if((totalSum - leftSum - nums[i]) == leftSum)
                return i;
        }
      return -1;  
}
}
