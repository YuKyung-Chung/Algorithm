import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //스위치 개수
		int[] arr = new int[T];
		
		//arr에 정보 입력
		for(int i=0; i<T; i++) {
			arr[i] = sc.nextInt();
		}
		
		int N = sc.nextInt(); //학생 수
		for(int k=0; k<N; k++) {
			int gender = sc.nextInt(); //성별
			int num = sc.nextInt(); //받은 수
			if(gender == 1) {
				for(int i=0; i<T; i++) {
					if((i+1) % num == 0)
						arr[i] = arr[i] == 0? 1: 0;
				}
			}
			else if(gender == 2) {
				//자기 자신은 무조건 바뀜
				arr[num-1] = arr[num-1] == 0? 1:0;
				
				for(int i=1; i<T/2; i++) {
					if(num-1-i < 0 || num-1+i >= T)
						break;
					if(arr[num-1-i] == arr[num-1+i]) {
						arr[num-1-i] = arr[num-1-i] == 0? 1 : 0;
						arr[num-1+i] = arr[num-1+i] == 0? 1 : 0;
					}
					else break;
				}
			}
			
		}
		for(int i=0; i<T; i++) {
			System.out.print(arr[i] + " ");
			if((i+1) % 20 == 0)
				System.out.println();
		}
	}
}
