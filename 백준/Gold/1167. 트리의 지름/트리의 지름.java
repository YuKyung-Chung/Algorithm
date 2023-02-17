import java.util.*;
class Edge{
        int e;
        int value;
        public Edge(int e, int value){
            this.e = e;
            this.value = value;
        }
    }
public class Main {
    static ArrayList<Edge>[] A;
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        A = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            A[i] = new ArrayList<Edge>();
        }
        
        for(int i=0; i<N; i++){
            int S = sc.nextInt();
            while(true){
                int E = sc.nextInt();
                if(E == -1)
                    break;
                int P = sc.nextInt();
                A[S].add(new Edge(E,P));
            }
        }
        
        visited = new boolean[N+1];
        distance = new int[N+1];
        BFS(1);
        int Max = 1;
        for(int i=2; i<=N; i++){
            if(distance[Max] < distance[i]){
                Max = i;
            }
        }
        distance = new int[N+1];
        visited = new boolean[N+1];
        BFS(Max);
        Arrays.sort(distance);
        System.out.println(distance[N]);
      
    }
    static void BFS(int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        
        while(!q.isEmpty()){
            int temp = q.poll();
            for(Edge i : A[temp]){
                int e = i.e;
                int v = i.value;
                
                if(!visited[e]){
                    visited[e] = true;
                    q.add(e);
                    distance[e] = distance[temp] + v; //거리 배열 업데이트하기
                }
            }
        }
    }
}