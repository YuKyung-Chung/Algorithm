import java.util.*;
public class Main {
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.next();
        String[] str = exp.split("-");

        for (int i = 0; i < str.length; i++) {
            int temp = mySum(str[i]);
            if (i == 0) {
                answer = answer + temp; //가장 앞에 있는 값은 더함
            } else {
                answer = answer - temp; //뒷부분은 더한 값들을 뺌
            }
        }
        System.out.println(answer);
    }

    public static int mySum(String str) { //더하기 연산 수행 함수
        String[] str2 = str.split("\\+");
        int sum = 0;
        for (int i = 0; i < str2.length; i++) {
            sum = sum + Integer.parseInt(str2[i]);
        }
        return sum;
    }
}