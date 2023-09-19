import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.equals("push_front")) {
				dq.addFirst(Integer.parseInt(st.nextToken()));
			}
			else if(cmd.equals("push_back")){
				dq.addLast(Integer.parseInt(st.nextToken()));
			}
			else if(cmd.equals("pop_front"))
				if(dq.isEmpty())
					System.out.println(-1);
				else
					System.out.println(dq.pollFirst());
			else if(cmd.equals("pop_back"))
				if(dq.isEmpty())
					System.out.println(-1);
				else
					System.out.println(dq.pollLast());
			else if(cmd.equals("size"))
				System.out.println(dq.size());
			else if(cmd.equals("empty")){
				if(dq.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
			}
			else if(cmd.equals("front")){
				if(dq.isEmpty())
					System.out.println(-1);
				else 
					System.out.println(dq.getFirst());
			}
			else if(cmd.equals("back")) {
				if(dq.isEmpty())
					System.out.println(-1);
				else 
					System.out.println(dq.getLast());
			}
		}
	}
}
