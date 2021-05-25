class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        // for(int i = 0;i < jewels.length();i++){
        //     for(int j = 0;j < stones.length();j++){
        //         if(jewels.charAt(i) == stones.charAt(j))
        //           count++;  
        //     }
        // }
        // return count;
        
        HashSet<Character> map = new HashSet<>();
        for(int i = 0;i < jewels.length();i++){
            map.add(jewels.charAt(i));
        }
        
        for(int i = 0;i < stones.length();i++){
            if(map.contains(stones.charAt(i)))
                count++;
        }
        return count;
    }
}
