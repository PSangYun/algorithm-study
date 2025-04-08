import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int solution(String[][] book_time) {

        List<int[]> books = new ArrayList<>();

        for (String[] time : book_time) {
            String start = time[0];
            String end = time[1];
            int startBoon = convertToMinutes(start);
            int endBoon = convertToMinutes(end) + 10;
            books.add(new int[] { startBoon, endBoon });
        }

        Collections.sort(books, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int answer = 0;

        for (int[] book : books) {
            int start = book[0];
            int end = book[1];

            while (!queue.isEmpty() && queue.peek() <= start) {
                queue.poll();
            }

            queue.offer(end);

            answer = Math.max(answer, queue.size());
        }
        return answer;
    }

    private int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}