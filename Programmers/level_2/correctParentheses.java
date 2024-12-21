// 올바른 괄호
// https://school.programmers.co.kr/learn/courses/30/lessons/12909

import java.util.*;

class Solution {
    boolean solution(String s) {
        
        boolean answer = true;  
        Stack<String> stack = new Stack<>();        
        
        // s가 ')'로 시작하면 false
        if(s.charAt(0) == ')'){
            return false;
        }
        
        // '(' 문자 : push
        // ')' 문자 : 
        //      1. stack에 값이 있으면 pop
        //      2. stack이 비어 있으면 false
        for(int i=0; i<s.length(); i++){            
            if(s.charAt(i) == '('){
                stack.push("(");
            }   
            if(!stack.isEmpty() && s.charAt(i) == ')'){
                stack.pop();
            } else if(stack.isEmpty() && s.charAt(i) == ')') {
                System.out.println("2");
                return false;
            }
        }        
        
        // stack이 비어 있으면 바르게 짝지어졌으므로 true
        // 반대의 경우에는 false
        if(stack.isEmpty()){
            answer = true;
        } else {
            answer = false;
        }
        
        return answer;
    }
}