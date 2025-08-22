import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int cnt = 0;
        
        while(cnt < commands.length) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = commands[cnt][0] - 1;i < commands[cnt][1];i++) {
                pq.offer(array[i]);
            }
            
            for (int i=1;i<commands[cnt][2];i++) {
                pq.poll();
            }
            
            answer[cnt] = pq.poll();
            cnt++;
        }
        

        System.out.println(commands.length);
        return answer;
    }
}