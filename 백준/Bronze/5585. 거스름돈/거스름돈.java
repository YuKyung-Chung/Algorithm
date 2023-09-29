import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //지불할 돈
		int[] money = new int[] {500,100,50,10,5,1};
		
		int last = 1000 - N;
		int cnt = 0;
		
		for (int i = 0; i < money.length; i++) {
			if(last / money[i] > 0) {
				cnt += last / money[i];
				last = last % money[i];
			}
		}
		System.out.println(cnt);
		
	}
}
