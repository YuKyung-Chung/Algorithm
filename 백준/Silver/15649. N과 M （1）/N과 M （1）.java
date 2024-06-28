import java.util.Scanner;

public class Main {
	//1부터 N까지 자연수 중 중복 없이 M개를 고른 수열
	static int[] sel;
	static boolean[] visited;
	static int N,M;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		sel = new int[M]; //M개를 고른 수열 저장하는 배열
		visited = new boolean[N+1]; //방문 여부 체크하는 배열
		sb = new StringBuilder();
		
		perm(0); //순열 생성 시작
		System.out.println(sb); //결과 출력
	}
	public static void perm(int depth) {
		//선택된 숫자 개수가 M이면 현재까지의 선택을 결과에 추가
		if(depth == M) {
			for(int val: sel) {
				sb.append(val).append(" ");
			}
			sb.append("\n"); //한 줄의 순열이 끝나면 개행 추가
			return; //함수 종료
		}
		
		//1부터 N까지 순회
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				visited[i] = true; //숫자 선택 표시
				sel[depth] = i; //선택된 숫자 저장
				perm(depth + 1); //다음 깊이로 재귀 호출
				visited[i] = false; //다른 조합을 위해 숫자 선택 해제
			}
		}
	}
}
