/*
* Longest substring without repeating charcaters = problem 3
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int count = 1,max = Integer.MIN_VALUE;
        if(s.length() == 0)
            return 0;
   outer:for(int i = 0;i < s.length();i++){
            for(int j = i + 1;j < s.length();j++){
                count = 1;
                for(int k = i;k < j;k++)
                {
                    if(s.charAt(j) == s.charAt(k))
                        continue outer;
                    else
                        count++;
                }
               max = Math.max(max,count); 
            }
        }
        return Math.max(max,count);
       
        
        
}
}
