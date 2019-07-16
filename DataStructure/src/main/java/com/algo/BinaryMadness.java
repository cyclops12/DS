package com.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BinaryMadness {

	public static void main(String[] args)throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bufferedReader.readLine());
		for(int i = 0;i<t;i++) {
			countKsubstringWithOddOne(bufferedReader.readLine());
		}
		bufferedReader.close();
		//System.out.println(countOfSubstringWithKOnes(s, K));
		
		
	}
	
	public static void countKsubstringWithOddOne(String s) {
		
		BigInteger y = new BigInteger(s);
		int setBits = y.bitCount();
		//System.out.println(y.toString(2));
		
		int totalOneComb =0; 
		String binaryRep = y.toString(2);
		for(int i = 1;i<=setBits;i = i+2) {
			totalOneComb=totalOneComb+countOfSubstringWithKOnes(binaryRep, i);
		}
		//System.out.print(totalOneComb);
		int totalZeroComb =0; 
		for(int i = 1;i<=binaryRep.length()-setBits;i = i+2) {
			totalZeroComb=totalZeroComb+countOfSubstringWithKOZeros(binaryRep, i);
		}
		
		System.out.println(totalZeroComb+" "+totalOneComb);
	}

	static int countOfSubstringWithKOnes(String s, int K) {
		
		int N = s.length();
		int res = 0;
		int countOf1 = 0;
		int[] f = new int[N + 1];


		f[0] = 1;

		for (int i = 0; i < N; i++) {

			countOf1 = countOf1+(s.charAt(i) - '0');

			if (countOf1 >= K) {

				res = res+f[countOf1 - K];
			}

			f[countOf1]++;
		}

		return res;
	}
	
	
	
static int countOfSubstringWithKOZeros(String s, int K) {
		
	int res = 0;
	int count0 = 0;
		int N = s.length();
		
		int[] f = new int[N + 1];

		f[0] = 1;

		for (int i = 0; i < N; i++) {

			count0 = count0+(-1*(s.charAt(i) - '1'));

			if (count0 >= K) {

				res = res+f[count0 - K];
			}

			f[count0]++;
		}

		return res;
	}

}
