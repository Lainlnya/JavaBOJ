
public class Combi {
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3};
		boolean[] visited = new boolean[arr.length];
		
		combi(arr, visited, 0, 2);
	}
	
	static void combi(int[] arr, boolean[] visited, int start, int r) {
		if (r == 0) {
			for (int i = 0; i < arr.length; i++) {
				if (visited[i]) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
			return;
		} else {
			for (int i = start; i < arr.length; i++) {
				visited[i] = true;
				combi(arr, visited, i + 1, r - 1);
				visited[i] = false;
			}
		}
	}
}
