import java.util.*;

class Solution {
    
    static String[] answer;
    static ArrayList<String> list;
    static boolean found;
    
    public String[] solution(String[][] tickets) {
        // 그래프 생성 및 두 번째 값을 기준으로 정렬
        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] a, String[] b) {
                return a[1].compareTo(b[1]);
            }
        });
        
        boolean[] visited = new boolean[tickets.length];
        list = new ArrayList<>();
        list.add("ICN");
        found = false;
        
        dfs(tickets, visited, "ICN", 0);
        
        answer = new String[list.size()];
        answer = list.toArray(answer);
        return answer;
    }
    private static void dfs(String[][] tickets, boolean[] visited, String str, int count){
        //모든 티켓을 다 사용한 경우
        if(count == tickets.length) {
            found = true;
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(str.equals(tickets[i][0]) && !visited[i]){
                list.add(tickets[i][1]);
                visited[i] = true;
                dfs(tickets, visited, tickets[i][1], count+1);
                if(found) return;
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }
}