import java.util.*;
public class Main {
    static int[][] tree;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        tree = new int[26][2];

        for (int i = 0; i < N; i++) {
            String[] temp = sc.nextLine().split(" ");
            int node = temp[0].charAt(0) - 'A'; //index로 변환하기 위해 A 문자 빼기
            char left = temp[1].charAt(0);
            char right = temp[2].charAt(0);

            //자식 노드 없을 때 -1 저장하기
            if (left == '.') {
                tree[node][0] = -1;
            } else {
                tree[node][0] = left - 'A';
            }

            if (right == '.') {
                tree[node][1] = -1;
            } else {
                tree[node][1] = right - 'A';
            }
        }
        preOrder(0); //전위 순회
        System.out.println();
        inOrder(0); //중위 순회
        System.out.println();
        postOrder(0); //후위 순회
        System.out.println();
    }

    static void preOrder(int now) {
        if (now == -1)
            return;
        //1.현재노드
        System.out.print((char) (now + 'A'));
        //2.왼쪽 탐색
        preOrder(tree[now][0]);
        //3.오른쪽 탐색
        preOrder(tree[now][1]);
    }

    static void inOrder(int now) {
        if (now == -1)
            return;
        //1.왼쪽 탐색
        inOrder(tree[now][0]);
        //2.현재 노드
        System.out.print((char) (now + 'A'));
        //3.오른쪽 탐색
        inOrder(tree[now][1]);
    }

    static void postOrder(int now) {
        if (now == -1)
            return;
        //1.왼쪽 탐색
        postOrder(tree[now][0]);
        //2.오른쪽 탐색
        postOrder(tree[now][1]);
        //3.현재 노드
        System.out.print((char) (now + 'A'));
    }
}
