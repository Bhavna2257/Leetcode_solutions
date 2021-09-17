class RomanToInteger {
    public int romantoInt(String s) {
        
        Map<Character , Integer> romanToInt = new HashMap<>();
        romanToInt.put('I' , 1);
        romanToInt.put('V' , 5);
        romanToInt.put('X' , 10);
        romanToInt.put('L' , 50);
        romanToInt.put('C' , 100);
        romanToInt.put('D' , 500);
        romanToInt.put('M' , 1000); 
        int intValue = 0;
        for(int i = 0 ; i < s.length() ; i++) {
            if((s.length() - i) >= 2 && (romanToInt.get(s.charAt(i)) < romanToInt.get(s.charAt(i + 1)))) {
                intValue = intValue + (romanToInt.get(s.charAt(i + 1)) - romanToInt.get(s.charAt(i)));
                i++;
            } else {
                intValue = intValue + (romanToInt.get(s.charAt(i)));
            }
        }
        return intValue;
    }
}
