import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String str = sc.next();
		int answer = 1;
		
		for(int i=0; i<str.length(); i++) {
			if(str.substring(i,i+1).equals("S")) 
				answer++;
			else {
				++i;
				answer++;
			}
		}
		
		if(answer > N)
			System.out.println(N);
		else
			System.out.println(answer);
	}
}
