import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < D + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            String sew = bf.readLine();
            StringTokenizer st2 = new StringTokenizer(sew);
            int start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st2.nextToken());
            int weight = Integer.parseInt(st2.nextToken());
            if (end <= D && weight < (end - start)) {
                graph.get(start).add(new int[] { end, weight });
            }
        }

        int[] dist = new int[D + 1];
        Arrays.fill(dist, 10001);
        dist[0] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        queue.add(new int[] { 0, 0 });

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentPos = current[0];
            int currentCost = current[1];

            if (currentCost > dist[currentPos]) {
                continue;
            }

            if (currentPos + 1 <= D && currentCost + 1 < dist[currentPos + 1]) {
                dist[currentPos + 1] = currentCost + 1;
                queue.add(new int[] { currentPos + 1, currentCost + 1 });
            }

            for (int[] next : graph.get(currentPos)) {
                int nextPos = next[0];
                int nextCost = currentCost + next[1];
                if (nextCost < dist[nextPos]) {
                    dist[nextPos] = nextCost;
                    queue.add(new int[] { nextPos, nextCost });
                }
            }
        }
        System.out.println(dist[D]);
    }
}