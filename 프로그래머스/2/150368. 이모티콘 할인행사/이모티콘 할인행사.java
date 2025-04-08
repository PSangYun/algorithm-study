class Solution {
  static int[] sale = {10, 20, 30, 40};
  static int[] input;
  static int uSize;
  static int eSize;
  static int[][] user;
  static int[] emo;
  static int maxPlus;
  static int maxCost;
  public int[] solution(int[][] users, int[] emoticons) {
    
    user = users;
    emo = emoticons;
    uSize = users.length;
    eSize = emoticons.length;
    input = new int[eSize];
    maxPlus = -1;
    maxCost = -1;

    dfs(0);

    int[] answer = {maxPlus, maxCost};
    return answer;
  }

  private static void dfs(int cnt) {
    if (cnt == eSize) {
      int curPlus = 0;
      int curCost = 0;
      for (int i=0;i<uSize;i++) {
        int cur = 0;
        for (int j=0;j<eSize;j++) {
          if (user[i][0] <= input[j]) {
            cur += (int)(emo[j] * (100 - input[j]) / 100);
          }
        }
        if (cur >= user[i][1]) {
          curPlus++;
        } else {
          curCost += cur;
        }
      }

      if (curPlus > maxPlus) {
        maxPlus = curPlus;
        maxCost = curCost;
      } else if (curPlus == maxPlus) {
        if (curCost > maxCost) {
          maxCost = curCost;
        }
      }

      return;
    }

    for (int i=0; i<4; i++) {
      input[cnt] = sale[i];
      dfs(cnt+1);
    }
  }
}