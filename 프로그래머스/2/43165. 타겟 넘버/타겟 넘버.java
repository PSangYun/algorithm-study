class Solution {
    public int solution(int[] numbers, int target) {
        int n = numbers.length;
        
        int[] branchNum = new int[n+1];
        for (int i=n-1;i>=0;i--) {
            branchNum[i] = branchNum[i+1] + numbers[i];
        }
        int answer = dfs(0, 0, numbers, target, branchNum);
        return answer;
    }
    
    private static int dfs(int i, int sum, int[] numbers, int target, int[] branchNum) {
        if (Math.abs(target - sum) > branchNum[i]) return 0;
        
        if (i == numbers.length) {
            if (sum == target) return 1;
            else return 0;
        }
        
        int plus = dfs(i+1, sum + numbers[i], numbers, target, branchNum);
        int minus = dfs(i+1, sum - numbers[i], numbers, target, branchNum);
        
        return plus + minus;
    }
}