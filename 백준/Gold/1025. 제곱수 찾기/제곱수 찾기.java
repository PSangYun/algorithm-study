import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] excel = new char[N][M];
        for (int i = 0; i < N; i++) {
            String l = bf.readLine().trim();
            excel[i] = l.toCharArray();
        }

        answer = -1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int dx = -N; dx <= N; dx++) {
                    for (int dy = -M; dy <= M; dy++) {
                        if (dx == 0 && dy == 0)
                            continue;

                        int x = i;
                        int y = j;
                        long num = 0;

                        while (x >= 0 && x < N && y >= 0 && y < M) {
                            int digit = excel[x][y] - '0';
                            num = num * 10 + digit;

                            long root = (long) Math.sqrt(num);
                            if (root * root == num) {
                                if (num > answer)
                                    answer = num;
                            }

                            x += dx;
                            y += dy;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
