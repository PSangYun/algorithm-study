import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        boolean[][] visited = new boolean[M][N]; // M : y, N : x

        for (int i = 0; i < K; i++) {
            String coo = bf.readLine();
            StringTokenizer st2 = new StringTokenizer(coo);
            int firstX = Integer.parseInt(st2.nextToken());
            int firstY = Integer.parseInt(st2.nextToken());
            int secondX = Integer.parseInt(st2.nextToken());
            int secondY = Integer.parseInt(st2.nextToken());

            for (int j = firstY; j < secondY; j++) {
                for (int k = firstX; k < secondX; k++) {
                    if (j < M && k < N) {
                        visited[j][k] = true;
                    }
                }
            }
        }

        Queue<int[]> queue = new LinkedList<int[]>();
        int count = 0;
        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j])
                    continue;
                else {
                    queue.add(new int[] { i, j });
                    count++;
                    int space = 1;
                    while (!queue.isEmpty()) {
                        int[] index = queue.poll();
                        int currentX = index[1];
                        int currentY = index[0];
                        visited[currentY][currentX] = true;

                        for (int k = 0; k < 4; k++) {
                            int nextX = currentX + dx[k];
                            int nextY = currentY + dy[k];
                            if (nextY >= 0 && nextY < M && nextX >= 0 && nextX < N) {
                                if (!visited[nextY][nextX]) {
                                    visited[nextY][nextX] = true;
                                    queue.add(new int[] { nextY, nextX });
                                    space++;
                                }
                            }
                        }
                    }
                    result.add(space);
                }
            }
        }
        Collections.sort(result);
        System.out.println(count);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}