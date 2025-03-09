class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        //wallet 작은 값
        int wallet_s = wallet[0];
        //wallet 큰 값
        int wallet_b = 0;
        if(wallet[1] > wallet_s){
            wallet_b = wallet[1];
        }
        else{
            wallet_b = wallet[0];
            wallet_s = wallet[1];
        }
        
        //bill 작은 값
        int bill_s = bill[0];
        //bill 큰 값
        int bill_b = 0;
        if(bill[1] > bill_s){
            bill_b = bill[1];
        }
        else{
            bill_b = bill[0];
            bill_s = bill[1];
        }
        
        //bill의 작은 값이 wallet의 작은 값 보다 크거나 bill의 큰 값이 wallet의 큰 값 보다 큰 동안 아래 과정을 반복합니다.
        while(bill_s > wallet_s || bill_b > wallet_b){
            //2-1. bill[0]이 bill[1]보다 크다면
            //     bill[0]을 2로 나누고 나머지는 버립니다.
            if(bill[0] > bill[1]){
                bill[0] = bill[0] / 2;
            }
            // 2-2. 그렇지 않다면
            //     bill[1]을 2로 나누고 나머지는 버립니다.
            else{
                bill[1] = bill[1] / 2;
            }
            // 2-3. answer을 1 증가시킵니다.
            answer++;
            
            if(bill[0] > bill[1]){
                bill_b = bill[0];
                bill_s = bill[1];
            }
            else{
                bill_b = bill[1];
                bill_s = bill[0];
            }
        }
        
        return answer;
    }
}