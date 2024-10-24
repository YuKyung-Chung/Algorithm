import java.util.*;

class Solution {
    public int[] solution(String s) {
        // 양쪽의 큰 중괄호를 제거
        s = s.substring(2, s.length() - 2);  // "{{"와 "}}" 제거
        String[] sets = s.split("\\},\\{");  // 각 집합을 나눔
        
        List<Set<Integer>> list = new ArrayList<>();
        
        for(String set: sets){
            String[] nums = set.split(",");
            Set<Integer> numSet = new HashSet<>();
            for(String num : nums){
                numSet.add(Integer.parseInt(num));
            }
            list.add(numSet);
        }
        
        //리스트 크기 순으로 정렬
        Collections.sort(list, Comparator.comparingInt(Set::size));
        
        Set<Integer> answerSet = new LinkedHashSet<>();
        for(Set<Integer> l : list){
            answerSet.addAll(l);
        }
        
        int[] answer = new int[answerSet.size()];
        int index = 0;
        for(int i : answerSet){
            answer[index] = i;
            index++;
        }
        
        return answer;
    }
}