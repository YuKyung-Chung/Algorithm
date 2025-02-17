class Solution {
    public String solution(String my_string) {
        String answer = "";
        String lower = my_string.toLowerCase(); //소문자로 변환
        String upper = my_string.toUpperCase();
        
        for(int i=0; i<my_string.length(); i++){
            //같으면 대문자로 변환
            if(lower.substring(i,i+1).charAt(0) == my_string.substring(i,i+1).charAt(0)){
                answer += upper.substring(i,i+1).charAt(0);
            }
            //다르면 소문자로
            else{
                answer += lower.substring(i,i+1).charAt(0);
            }
        }
        
        return answer;
    }
}