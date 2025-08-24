import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int maxX = 0;
        int maxY = 0;
        for (int i=0;i<sizes.length;i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }
        
        for (int i=0;i<sizes.length;i++) {
            if (maxX < sizes[i][0]) {
                maxX = sizes[i][0];
            }
            if (maxY < sizes[i][1]) {
                maxY = sizes[i][1];
            }
        }
        int answer = maxX * maxY;
        return answer;
    }
}