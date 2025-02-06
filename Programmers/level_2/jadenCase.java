// JadenCase 문자열 만들기
// https://school.programmers.co.kr/learn/courses/30/lessons/12951

import java.util.*;

class Solution {
    public String solution(String s) {
        
        StringBuilder sb = new StringBuilder("");
        
        for(int i=0; i<s.length(); i++){
            // 맨 첫 문자 예외처리
            if(i==0){
                if(s.charAt(i)==' '){
                    sb.append(' ');
                } else {
                    sb.append(Character.toUpperCase(s.charAt(i)));
                }
                continue;
            }
            // 현재 문자가 공백일 경우 > 공백 추가
            // 앞 문자가 공백일 경우 > 대문자
            // 앞 문자가 공백이 아닐 경우 > 소문자
            if(s.charAt(i) == ' '){
                sb.append(' ');
            } else if (s.charAt(i-1) == ' '){
                sb.append(Character.toUpperCase(s.charAt(i)));
            } else {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
 
        String answer = sb.toString();
        return answer;
    }
}