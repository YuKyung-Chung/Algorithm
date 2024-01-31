import java.io.*;
import java.util.*;

class TrieNode {
    HashMap<Character, TrieNode> children; 
    boolean isEndOfWord; //단어의 끝인지 여부
 
    TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

public class Main {
	static TrieNode root;
	
	//주어진 문자열 트라이에 삽입하는 메서드
    static void insert(String word) {
        TrieNode currentNode = root;
        for (char c : word.toCharArray()) {
            currentNode.children.putIfAbsent(c, new TrieNode());
            currentNode = currentNode.children.get(c); //현재 노드 방금 집어넣은 문자열로 갱신
        }
        currentNode.isEndOfWord = true;
    }
 
    //검사할 문자열 트라이에서 검색하는 메서드
    static boolean searchWord(String find) {
        TrieNode currentNode = root;
        for (char c : find.toCharArray()) {
            if (!currentNode.children.containsKey(c)) {
                return false;
            }
            currentNode = currentNode.children.get(c);
        }
        return true;
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
        String[] str = br.readLine().split(" ");
        int givenStr = Integer.parseInt(str[0]); //주어진 문자열 개수
        int findStr = Integer.parseInt(str[1]); //검사할 문자열 개수
 
        root = new TrieNode(); //트라이 선언
        //주어진 문자열 삽입
        for (int i = 0; i < givenStr; i++) {
            String string = br.readLine();
            insert(string);
        }
 
        int count = 0;
        //문자열 검사
        for (int i = 0; i < findStr; i++) {
            String find = br.readLine();
            if (searchWord(find)) {
                count++;
            }
        }
 
        System.out.println(count);
    }//main
}
