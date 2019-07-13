package com.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class solution {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {

		int t = Integer.parseInt(in.readLine());
		for (int i = 0; i < t; i++) {
			//System.out.println("test Case " + (i + 1));
			initChessBoardAndFindPath();
		}
		in.close();

	}

	private static void initChessBoardAndFindPath() throws Exception, IOException {
		maxTokenCount = 0;
		//totalPath = 0;
		maxPathCount = 0;	
		chessBoard = null;
		//maxPath = null;

		int n = Integer.parseInt(in.readLine());
		chessBoard = new String[n][n];
		for (int i = 0; i < n; i++) {
			String s[] = in.readLine().split("\\s+");
			int j = 0;
			for (String c : s) {
				chessBoard[i][j++] = c;
			}
		}
		findPath(n - 1, n - 1, 0, new boolean[n][n]);

	/*	if (maxPathCount == 0) {
			System.out.println("0 0");
		}*/
		System.out.println(maxTokenCount+" "+maxPathCount);
		/*System.out.println("Max Token=" + maxTokenCount);
		System.out.println("Total Path=" + totalPath);
		System.out.println("Max Path count=" + maxPathCount + "::" + maxPath);*/

	}

	static int maxTokenCount = 0;
	//static int totalPath = 0;
	static int maxPathCount = 0;
	static String[][] chessBoard = null;
	//static List<String> maxPath = null;

	/**
	 * 
	 * @param            i--current element ith point
	 * @param            j--current element jth point
	 * @param tokenCount
	 * @param isVisited
	 */
	private static void findPath(int i, int j, int tokenCount, boolean isVisited[][]) {
		isVisited[i][j] = true;
		if (chessBoard[i][j].equals("e")) {
			// reached end
			//System.out.print("path found::");
			if (maxTokenCount < tokenCount) {
				maxTokenCount = tokenCount;
				maxPathCount = 1;
				//maxPath = new ArrayList<>(path);
			} else if (maxTokenCount == tokenCount) {
				maxPathCount++;
				//maxPath = new ArrayList<>(path);
			}
			//totalPath++;
			/*System.out.print(path);
			System.out.println();*/
			return;
		}
		if (!chessBoard[i][j].equals("s")) {
			tokenCount = tokenCount + Integer.parseInt(chessBoard[i][j]);
		}
		List<List<Integer>> nextPoint = getNextPoints(i, j);
		for (int p = 0; p < nextPoint.size(); p++) {
			int nextI = nextPoint.get(p).get(0);
			int nextJ = nextPoint.get(p).get(1);
			if (chessBoard[nextI][nextJ].equals("x") && isVisited[nextI][nextJ]) {
				continue;
			}
			//path.add(nextI + "," + nextJ);
			findPath(nextI, nextJ, tokenCount, isVisited);
			//path.remove(nextI + "," + nextJ);
		}
		isVisited[i][j] = false;

	}

	private static List<List<Integer>> getNextPoints(int i, int j) {
		List<List<Integer>> nextPoints = new ArrayList<>();
		int arrPointerI = 0;
		// left
		if (j - 1 >= 0 && !chessBoard[i][j - 1].equals("x")) {
			nextPoints.add(arrPointerI, new ArrayList<>());
			nextPoints.get(arrPointerI).add(i);
			nextPoints.get(arrPointerI).add(j - 1);
			arrPointerI++;
		}
		// up
		if (i - 1 >= 0 && !chessBoard[i - 1][j].equals("x")) {
			/*
			 * nextPoints[arrPointerI][0]=i-1; nextPoints[arrPointerI][1]=j; arrPointerI++;
			 */

			nextPoints.add(arrPointerI, new ArrayList<>());
			nextPoints.get(arrPointerI).add(i - 1);
			nextPoints.get(arrPointerI).add(j);
			arrPointerI++;
		}
		// up-left
		if (i - 1 >= 0 && j - 1 >= 0 && !chessBoard[i - 1][j - 1].equals("x")) {
			/*
			 * nextPoints[arrPointerI][0]=i-1; nextPoints[arrPointerI][1]=j-1;
			 */
			nextPoints.add(arrPointerI, new ArrayList<>());
			nextPoints.get(arrPointerI).add(i - 1);
			nextPoints.get(arrPointerI).add(j - 1);
			arrPointerI++;
		}
		return nextPoints;
	}

}
