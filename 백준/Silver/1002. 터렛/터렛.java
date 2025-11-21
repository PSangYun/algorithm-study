import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int tc = 0;tc<T;tc++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int dx = x1 - x2;
            int dy = y1 - y2;
            if (dx == 0 && dy == 0) {
                if (r1 == r2) {
                    System.out.println(-1);
                    continue;
                } else {
                    System.out.println(0);
                    continue;
                }
            }

            int d = (int) (Math.pow(dx, 2) + Math.pow(dy, 2));
            double distance = Math.sqrt(d);

            if (distance > r1 + r2 || distance < Math.abs(r1- r2)) {
                System.out.println(0);
            } else if (distance == r1 + r2 || distance == Math.abs(r1 - r2)) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }
    }
}