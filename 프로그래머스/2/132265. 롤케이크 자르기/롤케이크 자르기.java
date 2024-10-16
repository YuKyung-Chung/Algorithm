import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        // 우측에 남아있는 토핑 종류를 기록할 Map
        Map<Integer, Integer> rightMap = new HashMap<>();
        // 좌측에 포함된 토핑 종류를 기록할 Set
        Set<Integer> leftSet = new HashSet<>();
        
        // 초기 상태: 우측에 모든 토핑을 넣는다
        for (int t : topping) {
            rightMap.put(t, rightMap.getOrDefault(t, 0) + 1);
        }
        
        // 왼쪽에서부터 하나씩 추가하고, 오른쪽에서 하나씩 제거
        for (int t : topping) {
            // 왼쪽 세트에 토핑 추가
            leftSet.add(t);
            
            // 오른쪽에서 해당 토핑 하나 제거
            rightMap.put(t, rightMap.get(t) - 1);
            if (rightMap.get(t) == 0) {
                rightMap.remove(t);
            }
            
            // 좌우의 토핑 종류 수가 같다면 카운트 증가
            if (leftSet.size() == rightMap.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}
