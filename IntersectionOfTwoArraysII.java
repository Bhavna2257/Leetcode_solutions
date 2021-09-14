Approach 1:
-----------

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer , Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        if(nums1.length <= nums2.length) {
            result = checkIntersection(nums1 , nums2 , map , result);
        } else {
            result = checkIntersection(nums2 , nums1 , map , result);
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++)
            res[i] = result.get(i);
        
        return res;
    }
    
    List<Integer> checkIntersection(int[] nums1 , int[] nums2 , Map<Integer , Integer> map , List<Integer> result) {
        
        for(int i = 0; i < nums1.length; i++) {
            if(map.containsKey(nums1[i])) {
                int value = map.get(nums1[i]) + 1;
                map.put(nums1[i] , value++);
            } else {
                map.put(nums1[i] , 1);
            }
        }
        
        for(int i = 0; i < nums2.length; i++) {
            if(map.containsKey(nums2[i])) {
                int value = map.get(nums2[i]);
                if(value > 0) {
                    value  = value - 1;
                    map.replace(nums2[i] , value);
                    result.add(nums2[i]);
                }
            }
        }
        return result;
        
    }
}


Approach 2:
-----------
Same as Approach 1 but little optimized.
In approach 1 I used separate array to store the result. However, in approach 2 I used one of the array to store the result as I copied that array before in Hashmap. This reduces to avoid extra space and reduces the lines of code.
  
  class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return intersect(nums2 , nums1);
        } 
        Map<Integer , Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++) {
            if(map.containsKey(nums1[i])) {
                int value = map.get(nums1[i]) + 1;
                map.put(nums1[i] , value++);
            } else {
                map.put(nums1[i] , 1);
            }
        }
        int k = 0;
        for(int i = 0; i < nums2.length; i++) {
            if(map.containsKey(nums2[i])) {
                int value = map.get(nums2[i]);
                if(value > 0) {
                    value  = value - 1;
                    map.replace(nums2[i] , value);
                    nums1[k++] = nums2[i];
                }
            }
        }
        
        return Arrays.copyOfRange(nums1 , 0 , k);
    }
}
