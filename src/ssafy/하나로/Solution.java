package 하나로;

import java.util.*;
import java.io.*;

public class Solution {
	static int n;
	static double e;
	static int[] x;
	static int[] y;
	static int[] parent;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());

			x = new int[n];
			y = new int[n];
			parent = new int[n];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				x[i] = Integer.parseInt(st.nextToken());
				parent[i] = i;
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}

			e = Double.parseDouble(br.readLine());

			PriorityQueue<Line> queue = new PriorityQueue<Line>(1, new Comparator<Line>() {

				@Override
				public int compare(Line o1, Line o2) {
					// TODO Auto-generated method stub
					return Double.compare(o1.cost, o2.cost);
				}
			});

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == j)
						continue;
					if (i < j) {
						queue.offer(new Line(i, j, getCost(x[i], y[i], x[j], y[j])));
					} else {
						queue.offer(new Line(j, i, getCost(x[i], y[i], x[j], y[j])));
					}
				}
			}

			int count = 0;
			double cost = 0;

			while (count < n - 1 && !queue.isEmpty()) {
				Line line = queue.poll();
				int parent1 = getParent(line.point1);
				int parent2 = getParent(line.point2);
				if (parent1 != parent2) {
					parent[parent2] = parent1;
					cost += line.cost;
					count++;
				}
			}
			stb.append('#').append(tc).append(' ').append(Math.round(cost)).append('\n');
		}
		System.out.println(stb.toString());
	}

	private static int getParent(int index) {
		if (parent[index] == index) {
			return index;
		} else {
			return getParent(parent[index]);
		}
	}

	private static double getCost(int x1, int y1, int x2, int y2) {
		int width = Math.abs(x1 - x2);
		int height = Math.abs(y1 - y2);

		double cost = e * (Math.pow(width, 2) + Math.pow(height, 2));

		return cost;
	}
}

class Line {
	int point1;
	int point2;
	double cost;

	public Line(int point1, int point2, double cost) {
		super();
		this.point1 = point1;
		this.point2 = point2;
		this.cost = cost;
	}
}
