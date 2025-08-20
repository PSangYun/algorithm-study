import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> deq = new ArrayDeque<>();
        
        for (int i=0;i<arr.length;i++) {
            deq.offer(arr[i]);
        }
        
        deq.offer(deq.poll());
        
        for (int i=1;i<arr.length;i++) {
            int cur = deq.poll();
            if (cur != deq.peekLast()) {
                deq.offer(cur);
            }
        }
        
        int size = deq.size();
        
        int[] answer = new int[size];
        
        for (int i=0;i<size;i++) {
            answer[i] = deq.poll();
        }

        return answer;
    }
}