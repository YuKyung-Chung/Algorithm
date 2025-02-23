class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        if(s.length() != 4 && s.length() != 6){
            return false;
        }
        for(int i=0; i<s.length(); i++){
            if(s.substring(i,i+1).charAt(0) - 'A' >= 0){
                answer = false;
                break;
            }
        }
        
        return answer;
    }
}