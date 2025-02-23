class Solution {
    public long solution(long n) {
        long answer = -1;
        for(int i=1; i<=10000000; i++){
            if(Math.pow(i,2) == n){
                answer = (long) Math.pow(i+1,2);
            }
        }
        return answer;
    }
}