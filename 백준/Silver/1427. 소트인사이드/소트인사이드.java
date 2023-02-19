import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        char[] list = sc.nextLine().toCharArray();
        Arrays.sort(list);
        for(int i=list.length-1; i>=0; i--){
            System.out.print(list[i]);
        }
    }
}