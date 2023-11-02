import java.util.Scanner;

public class Main {
	static class Node{
		char value;
		Node left;
		Node right;
		
		public Node(char value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	static int N; //트리 노드 개수
	static Node head = new Node('A',null,null); //루트 노드 지정
			
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //트리 노드 개수
		
		for (int i = 0; i < N; i++) {
			char now = sc.next().charAt(0);
			char left = sc.next().charAt(0);
			char right = sc.next().charAt(0);
			insertNode(head, now, left, right); //노드 정보 저장하기
		}
		
		preorder(head);
		System.out.println();
		inorder(head);
		System.out.println();
		postorder(head);
	}//main
	
	public static void insertNode(Node temp, char now, char left, char right) {
		//만약 현재 들어온 노드가 루트 노드와 같다면
		if(temp.value == now) {
			//왼쪽 노드에 값 저장
			temp.left = (left == '.'? null : new Node(left, null, null));
			//오른쪽 노드에 값 저장
			temp.right = (right == '.'? null : new Node(right, null, null));
		}
		//현재 들어온 노드가 루트 노드가 아니면
		else {
			//왼쪽 노드가 비어있지 않다면
			if(temp.left != null) {
				//타고 들어가면서 루트 노드가 같은 경우를 찾아보자.
				insertNode(temp.left, now, left, right);
			}
			//오른쪽 노드가 비어있지 않다면
			if(temp.right != null) {
				//타고 들어가면서 루트 노드가 같은 경우를 찾아보자.
				insertNode(temp.right, now, left, right);
			}
		}
	}
	
	//전위순회 (루트) (왼쪽 자식) (오른쪽 자식)
	public static void preorder(Node node) {
		if(node == null) return;
		System.out.print(node.value);
		preorder(node.left);
		preorder(node.right);
	}
	
	//중위순회 (왼쪽 자식) (루트) (오른쪽 자식)
	public static void inorder(Node node) {
		if(node == null) return;
		inorder(node.left);
		System.out.print(node.value);
		inorder(node.right);
	}
	
	//후위순회 (왼쪽 자식) (오른쪽 자식) (루트)
	public static void postorder(Node node) {
		if(node == null) return;
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.value);
	}

}
