class Solution {
    public String solution(String my_string, int num1, int num2) {
        char[] ch = new char[my_string.length()];
        for(int i=0; i<my_string.length(); i++){
            ch[i] = my_string.substring(i,i+1).charAt(0);
        }
        
        char now = ch[num1];
        char after = ch[num2];
        
        ch[num1] = after;
        ch[num2] = now;
        
        String answer = new String(ch);
        return answer;
    }
}