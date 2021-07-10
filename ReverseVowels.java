class Solution {
    public String reverseVowels(String s) {
        
        char[] ch = new char[s.length()];
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < s.length();i++)
        {
            ch[i] = s.charAt(i);
            if(ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u' || ch[i] == 'A' || ch[i] == 'E' || ch[i] == 'I' || ch[i] == 'O' || ch[i] == 'U')
                stack.push(ch[i]);
        }
        for(int i = 0;i < s.length();i++)
        {
            if(ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u' || ch[i] == 'A' || ch[i] == 'E' || ch[i] == 'I' || ch[i] == 'O' || ch[i] == 'U')
                ch[i] = stack.pop();
            else
                continue;
        }
        return String.valueOf(ch);   
    }
    
}
