package com.algo.traversal.matrix.bfs;

import java.util.*;

/*
 * this class has methods that calculate the shortest path between two points in a matrix
 */
/**
 * 
 * @author vdatla
 *
 */
class Point {
	int x;
	int y;

	public Point(int i, int j) {
		x = i;
		y = j;
	}

	@Override
	public String toString() {
		return "(" + this.x + "," + this.y + ")";
	}

	/**
	 * need to Override hashcode to generate unique hash for comparisions
	 */
	@Override
	public int hashCode() {
		return 37 * x + y;
	}

	@Override
	public boolean equals(Object obj) {
		Point o = (Point) obj;
		return o.x == this.x && o.y == this.y;
	}
}

class PathInAMatrix {
	static int[] arX = new int[] { -1, 1, 0, 0 };
	static int[] arY = new int[] { 0, 0, -1, 1 };

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 0, 0, 0, 0, 0, 1 }, 
									  { 0, 0, 1, 0, 0, 0 }, 
									  { 0, 0, 1, 0, 1, 0 },
									  { 1, 1, 0, 0, 0, 0 } };
		List<Point> res = getPath(matrix, new Point(2, 0), new Point(1, 5));
		for (Point p : res)
			System.out.print(p + "->");
	}

	public static boolean isValidPoint(Point p, int[][] matrix) {
		if (p.x < 0 || p.y < 0 || p.x >= matrix.length || p.y >= matrix[p.x].length)
			return false;
		return true;
	}

	/**
	 * method that generates neighboring valid points with value 0
	 * @param matrix
	 * @param p
	 * @return
	 */
	public static List<Point> getNeighbours(int[][] matrix, Point p) {
		List<Point> neighbours = new ArrayList<>();
		for (int i = 0; i < arX.length; i++) {
			Point newPoint = new Point(p.x + arX[i], p.y + arY[i]);
			if (isValidPoint(newPoint, matrix) && matrix[newPoint.x][newPoint.y] == 0) {
				neighbours.add(newPoint);
			}
		}
		return neighbours;
	}
/**
 * bfs to get path
 * @param matrix
 * @param source
 * @param target
 * @return
 */
	public static List<Point> getPath(int[][] matrix, Point source, Point target) {
		List<Point> res = new ArrayList<>();
		Set<Point> visited = new HashSet<>();
		if (matrix == null || !isValidPoint(source, matrix) || !isValidPoint(target, matrix))
			return res;
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(source);
		Map<Point, Point> map = new HashMap<>(); //map to store parent child
		visited.add(source);
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			List<Point> neighbours = getNeighbours(matrix, p);
			if (neighbours.contains(target)) {
				loadPath(res, p, map);
				break;
			}
			for (Point pt : neighbours) {
				if (!visited.contains(pt)) {
					map.put(pt, p);
					queue.add(pt);
					visited.add(pt);
				}
			}
		}
		Collections.reverse(res);
		return res;
	}

	/**
	 * load result by backtracking on hashmap
	 * 
	 * @param res
	 * @param p
	 * @param map
	 */
	private static void loadPath(List<Point> res, Point p, Map<Point, Point> map) {
		while (map.containsKey(p)) {
			res.add(p);
			p = map.get(p);
		}
	}
}
