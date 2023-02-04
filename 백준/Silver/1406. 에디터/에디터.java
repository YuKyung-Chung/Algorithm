import java.io.*;
import java.util.*;
public class Main { //커서의 왼쪽, 오른쪽 스택으로 나누어서 생각
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String first = br.readLine();
        int N = Integer.parseInt(br.readLine());

        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();

        for (int j = 0; j < first.length(); j++) {
            left.push(String.valueOf(first.charAt(j)));
        }


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            String str = st.nextToken();
            if (str.equals("L")) {
                if (!left.isEmpty()) {
                    right.push(left.pop());
                }
            } else if (str.equals("D")) {
                if (!right.isEmpty()) {
                    left.push(right.pop());
                }
            } else if (str.equals("B")) {
                if (!left.isEmpty()) {
                    left.pop();
                }
            } else if (str.equals("P")){
//                String next = st.nextToken();
                left.push(st.nextToken());
            }
        }

        while(!left.isEmpty())
            right.push(left.pop());

        while(!right.isEmpty())
            sb.append(right.pop());

        System.out.println(sb);
    }
}