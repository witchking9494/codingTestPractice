// [PCCP 기출문제] 1번 / 붕대 감기
// https://school.programmers.co.kr/learn/courses/30/lessons/250137

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        // bandage는 [시전 시간, 초당 회복량, 추가 회복량] 형태의 길이가 3인 정수 배열
        int t = bandage[0];     // 시전 시간
        int x = bandage[1];     // 초당 회복량
        int y = bandage[2];     // 추가 회복량
        int j = 0;              // attacks 행에 사용
        int combo = 0;          // 연속 성공 카운트
        int maxHealth = health; // 최대체력
        int lastAttack = attacks[attacks.length - 1][0];    // 마지막 공격
        
        
        
        // 마지막 공격이 이루어질때가지 체력 변화 계산
        for (int i=0; i <= lastAttack ;i++) {            
            // 공격 당했을 경우
            // 기술을 쓰는 도중 몬스터에게 공격을 당하면 기술이 취소
            // 공격을 당하는 순간에는 체력을 회복할 수 없음
            // 공격을 받으면 정해진 피해량만큼 현재 체력이 줄어듬
            // 현재 체력이 0 이하가 되면 캐릭터가 죽으며 더 이상 체력 회복 불가
            if (i == attacks[j][0]) {
                health = health - attacks[j][1];
                combo = 0;
                j++;
                if (health <= 0) {
                    return -1;
                }
            // 회복   
            // 붕대 감기는 t초 동안 붕대를 감으면서 1초마다 x만큼의 체력을 회복
            // t초 연속으로 붕대를 감는 데 성공한다면 y만큼의 체력을 추가로 회복
            // 현재 체력이 최대 체력보다 커지는 것은 불가능
            } else {
                health = health + x;
                combo += 1;
                if (t == combo) {
                    health += y;
                    combo = 0;
                }
                if (health >= maxHealth) {
                     health = maxHealth;
                }
            }
        }         
        
        // 모든 공격이 끝난 직후 남은 체력을 return
        return health;
    } 
}