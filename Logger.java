Time Complexity : O(1)
Space Complexity: O(M) where M is the length of all incoming messages.

Approach:
---------
class Logger {
    Map<String , Integer> map;
    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap<String , Integer>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(this.map.containsKey(message)) {
            int previousTimeStamp = this.map.get(message);
            if(timestamp >= previousTimeStamp + 10) {
                this.map.put(message , timestamp);
                return true;
            }
        } else {
            this.map.put(message , timestamp);
            return true;
        }
       return false; 
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
