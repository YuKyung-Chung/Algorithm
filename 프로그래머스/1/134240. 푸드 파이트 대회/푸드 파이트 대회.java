class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        for(int i=1; i<food.length; i++){
            for(int j=1; j<= food[i] / 2; j++){
                answer += i;   
            }
        }
        String newString = "";
        for(int i=answer.length()-1; i>=0; i--){
            newString += answer.substring(i,i+1);
        }
        
        
        answer += 0;
        answer += newString;
        
        return answer;
    }
}