class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for(int i=0; i<absolutes.length; i++){
            //양수이면
            if(signs[i]){
                answer += absolutes[i];
            }
            //음수이면
            else{
                answer += absolutes[i] * (-1);
            }
        }
        
        return answer;
    }
}