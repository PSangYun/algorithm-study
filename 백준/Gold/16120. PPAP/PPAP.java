import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String str = bf.readLine();
    int index = 0;

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == 'P')
        index++;
      else {
        if (i + 1 < str.length() && index >= 2 && str.charAt(i) == 'A'
            && str.charAt(i + 1) == 'P') { // 앞에 PP가 있고 현재 A고 다음에 P이면 PPAP가 P가 됨
          index--;
          i++;
        } else { // A일 때 앞에 PP가 아니면 틀림
          System.out.println("NP");
          return;
        }
      }
    }

    if (index == 1)
      System.out.println("PPAP");
    else
      System.out.println("NP");
  }

}
