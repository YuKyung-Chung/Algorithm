import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[K];
		
		long max = 0;
		
		for(int i=0; i<K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			
			//입력과 동시에 최댓값 갱신
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		
		max++; //반드시 max+1 이어야 함.
		
		long min = 0;
		long mid = 0;
		
		while(min < max) {
			
			//범위 내에서 중간 길이 구하기
			mid = (min + max) / 2;
			
			long count = 0;
			
			//구해진 중간 길이로 잘라서 몇개가 만들어지는지 구하기
			for(int i=0; i< arr.length; i++) {
				count += (arr[i]/mid);
			}
			
			if(count < N) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		
		//Upper bound로 얻어진 값(min)에 -1이 최대 길이가 된다.
		System.out.println(min - 1);
	}
}
