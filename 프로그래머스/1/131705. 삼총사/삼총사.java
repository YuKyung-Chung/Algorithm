class Solution {
    public int solution(int[] number) {
        int answer = 0;

        // 세 명을 모두 다르게 뽑아야 하므로 정확한 조합 구현
        for (int i = 0; i < number.length - 2; i++) {
            for (int j = i + 1; j < number.length - 1; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    if (number[i] + number[j] + number[k] == 0) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}
