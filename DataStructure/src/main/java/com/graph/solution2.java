package com.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class solution2 {
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


		int n = Integer.parseInt(in.readLine());
		chessBoard = new int[n][n];
		for (int i = 0; i < n; i++) {
			String s[] = in.readLine().split("\\s+");
			int j = 0;
			for (String c : s) {
				if(c.equals("x")||c.equals("s")||c.equals("e"))
				{
					chessBoard[i][j++] = 0;
				}
				else {
					chessBoard[i][j++] = Integer.parseInt(c);
				}
			}
		}
		
		dp2(n);



	}

	private static void dp(int n) {
		int dp[][] = new int[n][n];
		int ways[][] = new int[n][n];
		
		//row
		for(int i=n-2;i>=0;i--) {
			dp[n-1][i]=dp[n-1][i+1]+chessBoard[n-1][i];
		}
		for(int i=n-2;i>=0;i--) {
			dp[i][n-1]=dp[i+1][n-1]+chessBoard[i][n-1];
		}
		 
		 for(int i=n-2;i>=0;i--) {
			 for(int j=n-2;j>=0;j--) {
				 
				 dp[i][j]=dp[i+1][j+1]+chessBoard[i][j];
				 ways[i][j]=ways[i+1][j+1];
				 
				 if(dp[i][j]<dp[i+1][j]+chessBoard[i][j]) {
					 dp[i][j]=dp[i+1][j]+chessBoard[i][j];
					 ways[i][j] = ways[i+1][j];
				 }
				 else if(dp[i][j] == dp[i+1][j] + chessBoard[i][j]) {
					 ways[i][j] += ways[i+1][j];
				 }
				 
				 if(dp[i][j]<dp[i][j+1]+chessBoard[i][j]) {
					 dp[i][j]=dp[i][j+1]+chessBoard[i][j];
					 ways[i][j] = ways[i][j+1];
				 }
				 else if(dp[i][j] == dp[i][j+1] + chessBoard[i][j]) {
					 ways[i][j] += ways[i][j+1];
				 }
				
			 }
		 }
		 System.out.println("=========");
		 System.out.print(dp[0][0]);
		 System.out.print(" "+ways[0][0]);
		 System.out.println("=========");
		 
/*		dp[i,j] = dp[i+1,j+1] + board[i,j]
				ways[i,j] = ways[i+1,j+1]

				if dp[i,j] < dp[i+1,j] + board[i,j]:
				   dp[i,j] = dp[i+1,j] + board[i,j]
				   ways[i,j] = ways[i+1,j]

				elif dp[i,j] == dp[i+1,j] + board[i,j]:
				   ways[i,j] += ways[i+1,j]*/
	}
	
	
	
	private static void dp2(int n) {
		int dp[][] = new int[n][n];
		int ways[][] = new int[n][n];
		
		//row
		for(int i=n-2;i>=0;i--) {
			dp[n-1][i]=dp[n-1][i+1]+chessBoard[n-1][i];
		}
		for(int i=n-2;i>=0;i--) {
			dp[i][n-1]=dp[i+1][n-1]+chessBoard[i][n-1];
		}
		ways[n-1][n-1]=1;
		for(int i=n-2;i>=0;i--) {
			if(chessBoard[n-1][i]!=0)
			{
				ways[n-1][i]=ways[n-1][i+1];
			}
			if(chessBoard[i][n-1]!=0)
			{
				ways[i][n-1]=ways[i+1][n-1];
			}
			
		}
		 
		 for(int i=n-2;i>=0;i--) {
			 for(int j=n-2;j>=0;j--) {
				 
				 if(!(i==0 && j==0) && chessBoard[i][j]==0) {
					 continue;
				 }
				 dp[i][j]=dp[i+1][j+1]+chessBoard[i][j];
				 ways[i][j]=ways[i+1][j+1];
				 
				 if(dp[i][j]<dp[i+1][j]+chessBoard[i][j]) {
					 dp[i][j]=dp[i+1][j]+chessBoard[i][j];
					 ways[i][j] = ways[i+1][j];
				 }
				 else if(dp[i][j] == dp[i+1][j] + chessBoard[i][j]) {
					 ways[i][j] += ways[i+1][j];
				 }
				 
				 if(dp[i][j]<dp[i][j+1]+chessBoard[i][j]) {
					 dp[i][j]=dp[i][j+1]+chessBoard[i][j];
					 ways[i][j] = ways[i][j+1];
				 }
				 else if(dp[i][j] == dp[i][j+1] + chessBoard[i][j]) {
					 ways[i][j] += ways[i][j+1];
				 }
				
			 }
		 }
		// System.out.println("=========");
		 if(ways[0][0]==0) {
			 System.out.println("0 0");
			 return;
		 }
		 System.out.println(dp[0][0]+" "+ways[0][0]);
		// System.out.println(ways[0][0]);
		// System.out.println("=========");
		 
/*		dp[i,j] = dp[i+1,j+1] + board[i,j]
				ways[i,j] = ways[i+1,j+1]

				if dp[i,j] < dp[i+1,j] + board[i,j]:
				   dp[i,j] = dp[i+1,j] + board[i,j]
				   ways[i,j] = ways[i+1,j]

				elif dp[i,j] == dp[i+1,j] + board[i,j]:
				   ways[i,j] += ways[i+1,j]*/
	}
	

	static int[][] chessBoard = null;



}
