import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		int last = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.equals("push")) {
				last =Integer.parseInt(st.nextToken());
				q.add(last);
			}
			else if(cmd.equals("pop")){
				if(q.isEmpty())
					System.out.println(-1);
				else
					System.out.println(q.poll());
			}
			else if(cmd.equals("size"))
				System.out.println(q.size());
			else if(cmd.equals("empty")){
				if(q.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
			}
			else if(cmd.equals("front")){
				if(q.isEmpty())
					System.out.println(-1);
				else 
					System.out.println(q.peek());
			}
			else if(cmd.equals("back")) {
				if(q.isEmpty())
					System.out.println(-1);
				else 
					System.out.println(last);
			}
		}
	}
}
