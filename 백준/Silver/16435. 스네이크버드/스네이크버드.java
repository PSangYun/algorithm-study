import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int L;
	static int[] h;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		h = new int[N];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			h[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(h);

		for (int i = 0; i < N; i++) {
			if (h[i] > L)
				break;
			else {
				L += 1;
			}
		}

		System.out.println(L);
	}

}
