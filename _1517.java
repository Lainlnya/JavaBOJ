import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1517 {
	public static int[] arr;
	public static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public static void mergeSort(int left, int right) {
		if (left < right) {
			int mid = (left + right) >> 1;
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
		}
	}
	
	public static void merge(int left, int mid, int right) {
		int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
		int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);
		int idx = 0;
		
	}
}
