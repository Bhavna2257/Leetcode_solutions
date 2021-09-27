class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        
        List<List<Integer>> res = new ArrayList<>();
        int i = 0 , j = 0;
            while(i < s.length()) {
            List<Integer> temp = new ArrayList<>();
            int count = 1;
            j = i + 1;
            while(j < s.length()) {
                if(s.charAt(i) == s.charAt(j)) {
                    count++;
                } else {
                    break;
                }
                j++;
            }
            if(count >= 3) {
                temp.add(i);
                temp.add(j - 1);
                res.add(temp);
                i = j - 1;
            } else {
                i++;
            }
        }
        return res; 
}
       
}


