import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> subBelt = new Stack<>(); // 보조 컨테이너 벨트
        int currentBox = 1; // 메인 벨트에서 꺼낼 다음 상자 번호
        
        // 각 상자 순서대로 확인하며 실을 수 있는지 검토
        for (int target : order) {
            // 메인 벨트에서 target 상자를 꺼낼 때까지 subBelt로 이동
            while (currentBox <= target) {
                subBelt.push(currentBox++);
            }

            // 보조 벨트의 최상단이 target과 같다면 실을 수 있음
            if (!subBelt.isEmpty() && subBelt.peek() == target) {
                subBelt.pop();
                answer++;
            } else {
                break; // 실을 수 없는 경우 종료
            }
        }

        return answer;
    }
}
