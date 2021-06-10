/*
 * Leetcode problem 387 = First unique character in a string
 */

public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        
   Approach 1:
   -----------
   
        int n=s.length();
        int[] counter=new int[26];
        for(int i=0;i<n;i++)
        {
            counter[s.charAt(i)-'a']=counter[s.charAt(i)-'a']+1;
        }
        for(int i=0;i<n;i++)
        {
            if(counter[s.charAt(i)-'a']==1)
                return i;
        }
        return -1;
    }
}
   Approach 2:
   -----------
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < s.length();i++){
            if(map.containsKey(s.charAt(i)))
            {
                int count = map.get(s.charAt(i));
                count = count + 1;
                map.put(s.charAt(i),count);
            }
            else
                map.put(s.charAt(i),1);
        }
        for(int i = 0;i < s.length();i++){
            if(map.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
