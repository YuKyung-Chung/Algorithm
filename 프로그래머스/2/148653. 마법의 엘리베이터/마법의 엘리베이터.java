class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int currentDigit = storey % 10;  // 현재 자릿수 확인
            
            if (currentDigit > 5) {
                // 6 이상인 경우, 10 - currentDigit을 더해 올림
                answer += (10 - currentDigit);
                storey = storey / 10 + 1;  // 다음 자리로 올림
            } else if (currentDigit < 5) {
                // 4 이하인 경우, 그냥 자릿수만큼 더함
                answer += currentDigit;
                storey /= 10;  // 다음 자리로 이동
            } else {
                // 5인 경우, 다음 자릿수에 따라 결정
                int nextDigit = (storey / 10) % 10;
                if (nextDigit >= 5) {
                    answer += (10 - currentDigit);
                    storey = storey / 10 + 1;  // 올림
                } else {
                    answer += currentDigit;
                    storey /= 10;  // 그냥 이동
                }
            }
        }
        
        return answer;
    }
}
