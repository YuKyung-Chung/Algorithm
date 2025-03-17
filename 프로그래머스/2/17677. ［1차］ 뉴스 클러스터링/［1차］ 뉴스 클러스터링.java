import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        //모두 소문자로 변환
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        ArrayList<String> list1 = new ArrayList<>();
        //두 글자씩 끊어서 다중집합 원소 만들기
        for(int i=0; i<str1.length()-1; i++){
            //원본에서 i~i+2 추출
            String pair = str1.substring(i,i+2);
            //두 글자가 모두 알파벳인지 확인
            if(Character.isLetter(pair.charAt(0)) && Character.isLetter(pair.charAt(1))){
                list1.add(pair);
            }
        }
        ArrayList<String> cplist1 = new ArrayList<>(list1);
        
        ArrayList<String> list2 = new ArrayList<>();
        //두 글자씩 끊어서 다중집합 원소 만들기
        for(int i=0; i<str2.length()-1; i++){
            //원본에서 i~i+2 추출
            String pair = str2.substring(i,i+2);
            //두 글자가 모두 알파벳인지 확인
            if(Character.isLetter(pair.charAt(0)) && Character.isLetter(pair.charAt(1))){
                list2.add(pair);
            }
        }
        ArrayList<String> cplist2 = new ArrayList<>(list2);
        
        int same = SameJakard(cplist1, cplist2);
        int length = list1.size() + list2.size() - same;
        float ans = 0;
        //자카드 유사도 = 교집합 크기 / 합집합 크기
        ans = (list1.size() == 0 && list2.size() == 0)? 1 : (float) same / length;
        
        //A,B 모두 공집합일 경우 1로 정의
        return (int) (ans * 65536);
    }
    
    //교집합 구하는 메서드
    public static int SameJakard(ArrayList<String> cplist1, ArrayList<String> cplist2){
        int sum = 0;
        // cplist2는 교집합으로 카운트된 원소를 제거해가며 사용
        for (String s : cplist1) {
            if (cplist2.contains(s)) {
                cplist2.remove(s);
                sum++;
            }
        }
        return sum;
    }
    
    
}