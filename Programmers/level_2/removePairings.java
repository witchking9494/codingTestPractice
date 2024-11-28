// 2017 팁스타운 짝지어 제거하기
// https://school.programmers.co.kr/learn/courses/30/lessons/12973

import java.util.*;

class Solution
{
    public int solution(String s)
    {
        
        int answer = -1;
        
        Stack<Character> stack = new Stack<>();
        
        for (int i=0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            // stack이 비어있지 않고, Stack의 마지막 문자와 같으면 제거
            if(!stack.isEmpty() && stack.peek() == ch1) {
                stack.pop();
            // 같지 않다면 push
            } else {
                stack.push(ch1);
            }
        }
                       
        // stack이 비어있다면 문자열 모두 제거될 수 있다는 뜻이므로 1
        // 남은 문자가 있다면 0
        if(stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }

        
//         // 정상적으로 작동하나, 효율성 측면에서 보완 필요
//         // StringBuilder로 같은 알파벳 짝 제거
//         StringBuilder sb = new StringBuilder(s);        
        
//         for (int i=0; i < sb.length()-1; i++) {
//             char ch1 = sb.charAt(i);
//             char ch2 = sb.charAt(i+1);
//             if(ch1==ch2){
//                 sb.deleteCharAt(i);
//                 sb.deleteCharAt(i);
//                 // 이전 문자와 비교하기 위해 인덱스 조정
//                 i = Math.max(i - 2, -1);
//             }
//         }
        
//         // 문자열 모두 제거되었다면 1, 남아있다면 0
//         if(sb.length()==0){
//             return = 1;
//         } else {
//             return = 0;
//         }

    }
}