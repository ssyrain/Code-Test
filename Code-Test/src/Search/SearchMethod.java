package Search;

public class SearchMethod {

	/**
	 * given an array of num, judge whether exist sum of nums equal to k
	 * @param num
	 * @param k
	 * @return
	 */
	public static boolean sumEqualK(int[] num, int k) {
		return sumEqualKDFS(num, k, 0, 0);
	}
	
	private static boolean sumEqualKDFS(int[] num, int k, int sum, int i) {
		// TODO Auto-generated method stub
		if (sum == k) {
			return true;
		}else if (i >= num.length) {
			return false;
		}else {
			return sumEqualKDFS(num, k, sum + num[i], i + 1) || sumEqualKDFS(num, k, sum, i + 1);
		}
	}

	/**
	 * given a N*M garden, count puddles
	 * @param garden
	 * @return
	 */
	public static int countPuddle(char[][] garden) {
		int N = garden.length;
		int M = garden[0].length;
		int numPuddle = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (garden[i][j] == 'W') {
					countPuddleDFS(garden, i, j);
					numPuddle ++;
				}
			}
		}
		return numPuddle;
	}

	private static void countPuddleDFS(char[][] garden, int i, int j) {
		// TODO Auto-generated method stub
		garden[i][j] = '.';
		for (int dx = -1; dx <= 1; dx++) {
			for (int dy = -1; dy <= 1; dy++) {
				int nx = i + dx;
				int ny = j + dy;
				if (0 <= nx && nx < garden.length && 0 <= ny && ny < garden[0].length && garden[nx][ny] == 'W') {
					countPuddleDFS(garden, nx, ny);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] num1 = {1,2,4,7};
		int[][] num = {{1,2},{2,3},{3,4}};
		char[][] garden = {{'W','.','.','.','.','.','.','.','.','W','W','.'},
				           {'.','W','W','W','.','.','.','.','.','W','W','W'},
				           {'.','.','.','.','W','W','.','.','.','W','W','.'},
				           {'.','.','.','.','.','.','.','.','.','W','W','.'},
				           {'.','.','.','.','.','.','.','.','.','W','.','.'},
				           {'.','.','W','.','.','.','.','.','.','W','.','.'},
				           {'.','W','.','W','.','.','.','.','.','W','W','.'},
				           {'W','.','W','.','W','.','.','.','.','.','W','.'},
				           {'.','W','.','W','.','.','.','.','.','.','W','.'},
				           {'.','.','W','.','.','.','.','.','.','.','W','.'}};
//		System.out.println(num.length);
//		System.out.println(num[0].length);
//		System.out.println(sumEqualK(num1, 13));
		System.out.println(countPuddle(garden));
	}

}
