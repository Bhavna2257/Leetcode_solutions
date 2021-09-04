TC: O(N log N)
SC: O(N)

class MinimumCosttoConnectSticks {
    public int connectSticks(int[] sticks) {
      int minCost = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int stick : sticks) {
            pq.add(stick);
        }
        
        while(pq.size() > 1) {
            int stick1 = pq.remove();
            int stick2 = pq.remove();
            int cost = stick1 + stick2;
            minCost += cost;
            pq.add(cost);
        }
        return minCost;
    }
}
