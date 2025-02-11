import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(bf.readLine());

        if (n == 1) {
            System.out.println(0);
            return;
        }

        int prev = 1;
        int current = 2;

        for (int i = 2; i < n; i++) {
            int temp = current;
            current = (prev + current) % 10;
            prev = temp;
        }

        System.out.println(current);
    }
}