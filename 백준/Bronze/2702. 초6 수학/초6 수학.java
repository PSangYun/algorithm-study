import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            String s = bf.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int big = Math.max(a, b);
            int small = Math.min(a, b);
            int j = 1;
            int greastest = 0;
            int least = 0;

            while (true) {
                if ((big * j) % small == 0) {
                    least = big * j;
                    break;
                } else {
                    j++;
                }
            }

            for (int k = 1; k <= small; k++) {
                if (small % k == 0) {
                    if (big % (small / k) == 0) {
                        greastest = small / k;
                        break;
                    }
                }
            }

            System.out.println(least + " " + greastest);
        }
    }

}