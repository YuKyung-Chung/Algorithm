class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int idx = 0; // 단어 내부에서의 인덱스

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                idx = 0; // 공백이면 단어 내부 인덱스 초기화
                answer.append(c);
            } else {
                // 짝수 인덱스는 대문자, 홀수 인덱스는 소문자
                if (idx % 2 == 0)
                    answer.append(Character.toUpperCase(c));
                else
                    answer.append(Character.toLowerCase(c));
                idx++;
            }
        }
        return answer.toString();
    }
}