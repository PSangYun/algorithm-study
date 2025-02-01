import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int lc = 0;
    int uc = 0;
    int num = 0;
    int blank = 0;
    String N;
    while ((N = bf.readLine()) != null) {
      if (N.isEmpty()) {
        break;
      }

      for (char c : N.toCharArray()) {
        if (Character.isLowerCase(c))
          lc++;
        if (Character.isUpperCase(c))
          uc++;
        if (Character.isDigit(c))
          num++;
        if (Character.isSpaceChar(c))
          blank++;
      }
      System.out.println(lc + " " + uc + " " + num + " " + blank);
      lc = 0;
      uc = 0;
      num = 0;
      blank = 0;
    }

  }
}
