import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	static HashSet<String> set = new HashSet<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		//set에 접미사 추가
		for (int i = 0; i < str.length(); i++) {
			set.add(str.substring(i));
		}
		
		//배열로 바꾸기
		String[] strArr = set.toArray(new String[set.size()]);
		
		//오름차순 정렬
		Arrays.sort(strArr);
		
		//출력		
		for (int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i]);
		}
		
	}
}
