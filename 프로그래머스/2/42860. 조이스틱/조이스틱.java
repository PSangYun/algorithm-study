class Solution {
    public int solution(String name) {
        char[] alpha = name.toCharArray();
        int answer = 0;

        // 1. 알파벳 변경 로직
        for (int i=0; i< alpha.length;i++) {
            int up = alpha[i] - 'A';
            int down = 'Z' - alpha[i] + 1;
            answer += Math.min(up, down);
        }
        
        // 2. 커서 이동 로직
        int move = alpha.length - 1;
        for (int i=0;i<alpha.length;i++) {
            int next = i + 1;
            while(next < alpha.length && alpha[next] == 'A') next++;
            
            int currentCost = i + (alpha.length - next) + Math.min(i, alpha.length - next);
            move = Math.min(move, currentCost);
        }
        answer += move;

        return answer;
    }
}