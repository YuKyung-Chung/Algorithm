import java.util.*;

class Solution {
    static List<List<Integer>> graph;
    static int maxSheep = 0;

    public int solution(int[] info, int[][] edges) {
        graph = new ArrayList<>();
        for (int i = 0; i < info.length; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);  // 단방향 그래프 (트리)
        }

        // 시작은 노드 0에서, 양 1마리, 늑대 0마리, 방문 가능한 노드는 0번만
        List<Integer> canVisit = new ArrayList<>();
        canVisit.add(0);
        dfs(0, 0, canVisit, info);

        return maxSheep;
    }

    public void dfs(int sheep, int wolf, List<Integer> canVisit, int[] info) {
        // 현재 노드 리스트에서 하나씩 방문해보자
        for (int i = 0; i < canVisit.size(); i++) {
            int current = canVisit.get(i);
            int newSheep = sheep;
            int newWolf = wolf;

            if (info[current] == 0) newSheep++;
            else newWolf++;

            // 늑대 수가 같거나 많아지면 이 경로는 탈락
            if (newWolf >= newSheep) continue;

            // 최대 양 수 갱신
            maxSheep = Math.max(maxSheep, newSheep);

            // 다음 방문할 수 있는 노드 리스트 구성
            List<Integer> next = new ArrayList<>(canVisit);
            next.remove(i);
            next.addAll(graph.get(current)); // 현재 노드에서 갈 수 있는 자식 노드 추가

            dfs(newSheep, newWolf, next, info);
        }
    }
}
