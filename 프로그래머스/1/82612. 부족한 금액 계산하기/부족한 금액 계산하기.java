class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long sum = 0;//필요한 총 이용료
        for(int i=1; i<=count; i++){
            sum += price * i;
        }
        if(money - sum >= 0){
            answer = 0;
        }
        else{
            answer = sum - money;
        }

        return answer;
    }
}