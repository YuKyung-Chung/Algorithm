import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt(); //세로
		int W = sc.nextInt(); //가로
		
		int[] blocks = new int[W];
		for(int i=0; i<W; i++) {
			blocks[i] = sc.nextInt();
		}
		
		int result = 0;
		for(int i=1; i<W-1; i++) {
			int left = 0;
			int right = 0;
			
			for(int j=0; j<i; j++) {
				left = Math.max(left, blocks[j]);
			}
			
			for(int j=i+1; j<W; j++) {
				right = Math.max(right, blocks[j]);
			}
			
			if(blocks[i] < left && blocks[i] < right) {
				result += Math.min(left, right) - blocks[i];
			}
		}
		System.out.println(result);
	}
}
