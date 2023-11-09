import java.util.Scanner;

public class Main {
	static class Node{
		int value;
		Node right;
		Node left;
		
		public Node(int value, Node right, Node left) {
			this.value = value;
			this.right = right;
			this.left = left;
		}
		
		public Node(int value) {
			this.value = value;
		}

		public void insert(int now) {
			//작을 때
			if(now < this.value) {
				if(this.left == null) {
					this.left = new Node(now);
				}else {
					this.left.insert(now);
				}
			}
			//클때
			else {
				if(this.right == null) {
					this.right = new Node(now);
				}else {
					this.right.insert(now);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Node head = new Node(sc.nextInt());
		
		String now;
		while(sc.hasNext()) {
			now = sc.next();
			if(now == null || now.equals("")) {
				break;
			}
			head.insert(Integer.parseInt(now));
		}
		
		postOrder(head);
	}//main
	
	//후위순회(왼쪽-오른쪽-루트)
	public static void postOrder(Node now) {
		if(now == null) return;
		postOrder(now.left);
		postOrder(now.right);
		System.out.println(now.value);
	}

}
