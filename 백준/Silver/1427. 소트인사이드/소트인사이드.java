import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] A = sc.nextLine().toCharArray();
        Arrays.sort(A);
        
        for(int i=A.length-1; i>=0; i--){
            System.out.print(A[i]);
        }
        
    }
}