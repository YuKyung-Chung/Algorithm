class Solution {
    public String solution(String rsp) {
        
        char[] chArr = new char[rsp.length()];
        for(int i=0; i<rsp.length(); i++){
            chArr[i] = rsp.substring(i,i+1).charAt(0);
        }
        
        
        for(int i=0; i<chArr.length; i++){
            chArr[i] = play(chArr[i]);
        }
        String answer = new String(chArr);
        return answer;
    }
    
    public static char play(char ch){
        if(ch == '2'){
            return '0';
        }
        else if(ch == '0'){
            return '5';
        }
        else{
            return '2';
        }
    }
}