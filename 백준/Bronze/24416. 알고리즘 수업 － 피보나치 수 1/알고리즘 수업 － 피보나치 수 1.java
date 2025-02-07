import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int regcount;
	static int dynacount;
	static int[] fibarr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		regcount = 0;
		dynacount = 0;
		
		fibarr = new int[n+1];
		
		fib(n);
		fibnacci(n);
		
		System.out.println(regcount + " " + dynacount);

	}

	private static int fibnacci(int n) {
		fibarr[1] = 1;
		fibarr[2] = 1;
		for (int i=3;i<n+1;i++) {
			fibarr[i] = fibarr[i-1] + fibarr[i-2];
			dynacount++;
		}
		return fibarr[n];
	}

	private static int fib(int n) {
		if (n == 1|| n == 2) {
			regcount++;
			return 1;
		} else {
			return (fib(n-1) + fib(n-2));
		}
		
	}

}
