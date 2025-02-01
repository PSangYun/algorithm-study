import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(bf.readLine());
    int temp = N;
    int count = 0;

    while (true) {
      int a = temp / 10;
      int b = temp % 10;
      temp = b * 10 + ((a + b) % 10);
      count++;
      if (temp == N)
        break;
    }

    System.out.println(count);
  }
}
