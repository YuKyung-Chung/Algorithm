
import java.util.Scanner;

public class Solution {
	public static void main(String[] args)   {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			boolean isTrue = true;
			String binary = Integer.toBinaryString(M);
			if(binary.length() < N)
				isTrue = false;
			
			//M의 이진수 마지막 N비트가 모두 1로 켜져있는지 아닌지 판별
			if(isTrue) {
				for (int i = binary.length()-N; i < binary.length(); i++) {
					if(binary.charAt(i) == '0') {
						isTrue = false;
						break;
					}
				}
			}
			
			if(isTrue) System.out.printf("#%d %s\n", tc, "ON");
			else System.out.printf("#%d %s\n", tc, "OFF");
		}//tc
	}//main
}
