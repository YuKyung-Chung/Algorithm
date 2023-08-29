
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		// 암호 8개 숫자
		String[] code = {"0001101","0011001","0010011","0111101","0100011","0110001","0101111","0111011","0110111","0001011"};
		
		int T = sc.nextInt(); //테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); //세로
			int M = sc.nextInt(); //가로
			
			//전체 배열 입력 받기
			String[][] arr = new String[N][M];
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < M; j++) {
					arr[i][j] = str.substring(j,j+1);
				}
			}
			
			String[] secret = new String[56]; //해독해야 할 56자리 암호
			
			find: for (int i = 0; i < N; i++) {
				for (int j = M-1; j >= 0; j--) {
					//뒤에서 부터 순회하다가 1 나오면 거기서부터 56자리 저장
					if(arr[i][j].equals("1")) {
						for (int k = 55; k >= 0; k--) {
							secret[k] = arr[i][j];
							j--;
						}
						break find;
					}
				}
			}
			
			String decode = "";//해독한 숫자 저장하는 배열
			int i = 0;
			//56자리 7자리씩 나눠서 암호 해독
			while (i < secret.length) {
				String tmp = "";
				for (int j = 0; j < 7; j++) {
					tmp += secret[i++];
				}
				
				for (int j = 0; j < 10; j++) {
					if(tmp.equals(code[j])) {
						decode += j;
					}
				}
			}
			
			int odd = 0; //홀수 합 저장 변수
			int even = 0; //짝수 합 저장 변수
			// (홀수 자리의 합 x 3) + (짝수 자리의 합)이 10의 배수
			for (int j = 0; j < decode.length(); j++) {
				//짝수인경우
				if((j+1) % 2 ==0) {
					even += Integer.parseInt(decode.substring(j,j+1));
				}
				//홀수인경우
				else {
					odd += Integer.parseInt(decode.substring(j,j+1));
				}
			}
			//올바른 암호코든지 검증
			if((odd*3 + even) % 10 == 0) {
				System.out.printf("#%d %d\n",tc,even+odd);
			}else {
				System.out.printf("#%d %d\n",tc,0);
			}
		}//tc
	}//main
}
