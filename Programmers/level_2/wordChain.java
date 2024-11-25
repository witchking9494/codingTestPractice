// Summer/Winter Coding(~2018) 영어 끝말잇기
// https://school.programmers.co.kr/learn/courses/30/lessons/12981

// import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        
        int[] answer = new int[2];
        // 등장한 단어를 저장하기 위한 hashmap
        // HashMap<String, Integer> map = new HashMap<>();
        
        
        // 중복 방지를 위해서는 hashset을 이용하는 것이 보다 효율적
        HashSet<String> set = new HashSet<>();
        
        // 끝말잇기가 정상적으로 수행되었는지 확인
        for(int i = 0; i < words.length; i++) {            
            // 첫 번째 단어는 통과
            if (i>0) {
                char lastLetter = words[i - 1].charAt(words[i - 1].length() - 1);   // 이전 단어의 마지막 문자
                char firstLetter = words[i].charAt(0);                              // 현재 단어의 첫 문자
                // 마지막 글자와 첫 번째 글자가 일치하지 않는 경우, 탈락
                if (lastLetter != firstLetter) {
                    answer[0] = (i % n) + 1;
                    answer[1] = (i / n) + 1;
                    return answer;
                }
            }        
            
            
            // // map에 해당 단어가 저장되어 있지 않다면 추가
            // if (map.getOrDefault(words[i],0) == 0) {
            //     map.put(words[i], 1);
            // // 저장되어 있다면, 해당 turn을 저장한 후 break    
            // } else {
            //     answer[0] = (i % n) + 1;
            //     answer[1] = (i / n) + 1;
            //     return answer;
            // }
            
            
            // HashSet에 해당 단어가 존재하는 경우, 탈락
            if(set.contains(words[i])) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                return answer;
            }
            
            // 중복 방지 위해 HashSet에 단어 추가
            set.add(words[i]);
            
        }               

        return answer;
    }
}