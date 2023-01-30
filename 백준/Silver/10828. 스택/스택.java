import java.io.*;
import java.util.*;

public class Main{    
    public static int stack[]; //스택 배열
    public static int k=0; //스택 포인트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        stack = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(pop()).append('\n');
                    break;
                case "size":
                    sb.append(size()).append('\n');
                    break;
                case "empty":
                    sb.append(empty()).append('\n');
                    break;
                case "top":
                    sb.append(top()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }

    public static void push(int x) {
        stack[k] = x;
        k++;
    }

    public static int pop() {
        if (k == 0) {
            return -1;
        } else {
            int answer = stack[k-1];
            k--;
            return answer;
        }
    }

    public static int size() {
        return k;
    }
    
    public static int empty() {
        if (k == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int top() {
        if (k == 0) {
            return -1;
        } else {
            return stack[k-1];
        } 
    }
}