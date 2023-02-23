class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split(" ");
        for(int i=0; i<str.length; i++){
            String now = str[i]; 
            if(str[i].length() == 0){
                answer += " ";
            } else{
                // 0번째 문자는 대문자로
    			answer += now.substring(0, 1).toUpperCase();
    			// 1번째 문자부터 마지막까지는 소문자로
    			answer += now.substring(1, now.length()).toLowerCase();
    			// 마지막에 " " 추가
    			answer += " ";
            }
        }
        if(s.substring(s.length()-1, s.length()).equals(" "))
            return answer;
        return answer.substring(0,answer.length()-1);
    }
}