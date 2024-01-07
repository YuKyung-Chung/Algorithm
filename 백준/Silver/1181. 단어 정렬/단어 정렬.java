import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		 HashSet<String> set = new HashSet<>();
		 
		 int num = Integer.parseInt(br.readLine());
		 
		 //set에 담아서 중복 제거
		 for (int i = 0; i < num; i++) {
			set.add(br.readLine());
		 }
		 
		 //배열로 옮겨담기
		 String[] strArr = set.toArray(new String[set.size()]);
		 
		
		 for (int i = 0; i < strArr.length-1; i++) {
			for (int j = i; j < strArr.length; j++) {
				if(strArr[i].length() < strArr[j].length()) {
					continue;
				}
				
				//길이 짧은거 부터
				if(strArr[i].length() > strArr[j].length() ) {
					 String temp = strArr[i];
					 strArr[i] = strArr[j];
					 strArr[j] = temp;
				} 
				//길이 같으면 사전순
				else if(strArr[i].length() == strArr[j].length()) {
					if(strArr[i].compareTo(strArr[j]) > 0) {
						String temp = strArr[i];
						 strArr[i] = strArr[j];
						 strArr[j] = temp;
					}
				}
			}
			
		}
		 
		//출력
		for (int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i]);
		}
	}
}
