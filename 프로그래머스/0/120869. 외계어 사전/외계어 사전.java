import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        // spell의 알파벳을 정렬하여 기준 문자열 생성
        String sortedSpell = String.join("", spell);
        char[] spellChars = sortedSpell.toCharArray();
        Arrays.sort(spellChars);
        String sortedSpellKey = new String(spellChars);

        // dic에서 각 단어를 정렬한 후 spell과 비교
        for (String word : dic) {
            char[] wordChars = word.toCharArray();
            Arrays.sort(wordChars);
            String sortedWordKey = new String(wordChars);

            if (sortedSpellKey.equals(sortedWordKey)) {
                return 1; // 일치하는 단어가 존재하면 1 반환
            }
        }

        return 2; // 일치하는 단어가 없으면 2 반환
    }
}
