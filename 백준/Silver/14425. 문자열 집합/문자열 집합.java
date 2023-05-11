import java.util.Scanner;

class tNode {
    tNode[] next = new tNode[26];
    boolean isEnd; //문자열의 마지막 유무 표시
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        tNode root = new tNode();
        while (N > 0) {
            String text = sc.next();
            tNode now = root;
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (now.next[c - 'a'] == null) {
                    now.next[c - 'a'] = new tNode();
                }
                now = now.next[c - 'a'];
                if (i == text.length() - 1) {
                    now.isEnd = true;
                }
            }
            N--;
        }
        int count = 0;
        while (M > 0) {
            String text = sc.next();
            tNode now = root;
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (now.next[c - 'a'] == null) {
                    break;
                }
                now = now.next[c - 'a'];
                if(i == text.length() -1 && now.isEnd) //문자열의 끝이고 현재까지 모두 일치하면
                    count++;
            }
            M--;
        }
        System.out.println(count);
    }
}
