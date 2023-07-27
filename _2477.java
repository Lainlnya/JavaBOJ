import java.io.*;
import java.util.*;

public class _2477 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int melon = Integer.parseInt(br.readLine());
		List<Integer> upDown = new ArrayList<>();
		List<Integer> rightLeft = new ArrayList<>();
		List<Integer> total = new LinkedList<>();
		
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a <= 2) {
				rightLeft.add(b);
			} else {
				upDown.add(b);
			}
			total.add(b);
		}
		
		int up = Collections.max(upDown), right = Collections.max(rightLeft);
		
		int rowIndex = total.indexOf(up);
		int rowIndexLeft = rowIndex - 1 >= 0 ? rowIndex - 1 : rowIndex - 1 + 6;
		int rowIndexRight = rowIndex + 1 > 5 ? rowIndex + 1 - 6 : rowIndex + 1;
		
		int columnIndex = total.indexOf(right);
		int	columnIndexLeft = columnIndex - 1 >= 0 ? columnIndex - 1 : columnIndex - 1 + 6;
		int	columnIndexRight = columnIndex + 1 > 5 ? columnIndex + 1 - 6 : columnIndex + 1;
		
		System.out.println((up * right - (Math.abs(total.get(rowIndexLeft) - total.get(rowIndexRight)) * Math.abs(total.get(columnIndexLeft) - total.get(columnIndexRight)))) * melon);
	
	}
	
}
