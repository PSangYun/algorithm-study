import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Integer i: nums) {
            if (map.containsKey(i)) {
                map.replace(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        
        int answer = 0;
        if (map.size() < nums.length/2) {
            answer = map.size();
        } else {
            answer = nums.length/2;
        }
        return answer;
    }
}