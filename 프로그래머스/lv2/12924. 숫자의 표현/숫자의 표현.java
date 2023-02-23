class Solution {
    public int solution(int n) {
        int count = 1;
        int start = 0;
        int end = 0;
        int sum = 0;
        while(end != n){
            if(sum == n){
                count++;
                end++;
                sum = sum + end;
            } else if(sum > n){
                sum = sum - start;
                start++;
            } else{
                end++;
                sum = sum + end;
            }
        }
        return count;
    }
}