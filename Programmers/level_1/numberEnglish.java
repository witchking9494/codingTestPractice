// 2021 카카오 채용연계형 인턴십 숫자 문자열과 영단어
// https://school.programmers.co.kr/learn/courses/30/lessons/81301

class Solution {
    public int solution(String s) {
        
        // 숫자에 대응되는 영단어 배열
        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        // 영단어를 숫자로 변경
        for (int i = 0; i < words.length; i++) {
            // 각 영단어를 찾고 숫자로 교체
            // ex) zero -> 0, one -> 1 
            s = s.replace(words[i], Integer.toString(i));
        }
        
        // 변환된 문자열을 숫자로
        return Integer.parseInt(s);
    }
}