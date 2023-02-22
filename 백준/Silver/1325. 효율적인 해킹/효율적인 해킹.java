import java.util.*;
public class Main {
    static int N,M;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int[] answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        A = new ArrayList[N+1];
        answer = new int[N+1];
        for(int i=1; i<=N; i++){
            A[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            int S = sc.nextInt();
            int P = sc.nextInt();
            A[S].add(P);
        }
        
       //모든 노드에서 BFS 실행
        for(int i=1; i<=N;i++){
            visited = new boolean[N+1];
            BFS(i);
        }
        int maxVal = 0;
        for(int i=1; i<=N; i++){
            maxVal = Math.max(maxVal, answer[i]);
        }
        for(int i=1;i<=N; i++){
            if(answer[i] == maxVal){
                System.out.print(i + " ");
            }
        }
        
    }
    static void BFS(int index){
        Queue<Integer> q = new LinkedList<>();
        q.add(index);
        visited[index] = true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i:A[now]){
                if(!visited[i]){
                    visited[i] = true;
                    answer[i]++;
                    q.add(i);
                }
            }
        }
        
    }
}