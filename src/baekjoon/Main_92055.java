package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_92055 {
	static int N;
	static ArrayList<ArrayList<Integer>> posList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			ArrayList<Store> list = new ArrayList<>();

			for (int i = 0; i < N + 2; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				list.add(new Store(r, c));
			}

			posList = new ArrayList<>();
			for (int i = 0; i < N + 2; i++) {
				posList.add(new ArrayList<>());
			}

			for (int i = 0; i < N + 2; i++) {
				for (int j = i + 1; j < N + 2; j++) {
					if (isPossible(list.get(i), list.get(j))) {
						posList.get(i).add(j);
						posList.get(j).add(i);
					}
				}
			}

			if (bfs())
				sb.append("happy");
			else
				sb.append("sad");

			sb.append("\n");

		}
		System.out.print(sb);
	}

	private static boolean bfs() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 2];
		q.offer(0);
		visited[0] = true;

		while (!q.isEmpty()) {
			int now = q.poll();
			if (now == N + 1)
				return true; 

			for (int next : posList.get(now)) { 
				if (visited[next])
					continue; 
				visited[next] = true;
				q.offer(next);
			}
		} 

		return false; 
	}
	private static boolean isPossible(Store pos1, Store pos2) {
		return (Math.abs(pos1.r - pos2.r) + Math.abs(pos1.c - pos2.c)) <= 1000;
	}

	static class Store {
		int r;
		int c;

		public Store(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}