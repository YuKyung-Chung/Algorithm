class Solution {
    public int solution(int slice, int n) {
        int answer = 1;
        while(slice < n){
            answer = answer + 1;
            if(slice * answer >= n){
                break;
            }
        }
        return answer;
    }
}