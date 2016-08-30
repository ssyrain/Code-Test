package Search;

import java.util.LinkedList;
import java.util.Queue;

public class SearchMethod {

	/**
	 * @problemType DFS
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
	 * @problemType DFS
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
	
	/**
	 * @problemType BFS
	 * given a N*M maze, count min path
	 * @param maze
	 * @param startX
	 * @param startY
	 * @param endX
	 * @param endY
	 * @return
	 */
	class Site {
		int x;
		int y;
		public Site(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
//	public static int minPath(char[][] maze, int startX, int startY, int endX, int endY) {
//		int N = maze.length;
//		int M = maze[0].length;
//		int MAX = 2 * N * M;
//		int[][] minPathMatrix = new int[N][M];
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				minPathMatrix[i][j] = MAX;
//			}
//		}
//		Queue<Site> queue = new LinkedList<Site>();
//		
//		queue.add(new Site(startX, startY));
//		while (!queue.isEmpty()) {
//			
//		}
//	}

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
