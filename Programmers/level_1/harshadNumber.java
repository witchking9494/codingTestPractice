// 하샤드 수
// https://school.programmers.co.kr/learn/courses/30/lessons/12947

class Solution {
    public boolean solution(int x) {
       
        boolean answer = false;
        
        // x를 String으로 변환
        String xString = Integer.toString(x);
        int result = 0;
        
        // x의 모든 자릿수의 합 구하기
        for(int i=0; i<xString.length(); i++){
            result += Character.getNumericValue(xString.charAt(i));
        }
        
        // x와 합이 나누어 떨어지면 하샤드 수
        if(x%result==0){
            answer = true;
        } else {
            answer = false;
        }
        
        return answer;
    }
}