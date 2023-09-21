import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		HashSet<String> set = new HashSet<>();
		List<String> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			set.add(sc.next());
		}
		for (int i = 0; i < M; i++) {
			String str = sc.next();
			if(set.contains(str)) {
				list.add(str);
			}
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for (String s : list) {
			System.out.println(s);
		}
	}
}
