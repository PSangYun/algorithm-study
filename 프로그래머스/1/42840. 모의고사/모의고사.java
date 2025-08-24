import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] m1 = {1,2,3,4,5};
        int[] m2 = {2,1,2,3,2,4,2,5};
        int[] m3 = {3,3,1,1,2,2,4,4,5,5};

        int s1 = 0, s2 = 0, s3 = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == m1[i % m1.length]) s1++;
            if (answers[i] == m2[i % m2.length]) s2++;
            if (answers[i] == m3[i % m3.length]) s3++;
        }

        int max = Math.max(s1, Math.max(s2, s3));
        List<Integer> res = new ArrayList<>();
        if (s1 == max) res.add(1);
        if (s2 == max) res.add(2);
        if (s3 == max) res.add(3);

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}