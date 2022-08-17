package com.ysh.array;

public class ArrayInArrayExample {

	public static void main(String[] args) {

		int[][] mathScroes = new int[2][3];
		for (int i = 0; i < mathScroes.length; i++) {
			for (int k = 0; k < mathScroes[i].length; k++) {
				System.out.println("mathScores[" + i + "][" + k + "] = " + mathScroes[i][k]);
				
			}
		}
		System.out.println();

		int[][] englishScores = new int[2][];

		englishScores[0] = new int[2];
		englishScores[1] = new int[3];
		for (int i = 0; i < englishScores.length; i++) {
			for (int k = 0; k < englishScores[i].length; k++) {
				System.out.println("englishScores[" + i + "][" + k + "] = " + englishScores[i][k]);
			}
		}
		System.out.println();
	
		int[][] javaScores = {{95,80} , {92,96,80}};
		for(int i = 0; i<javaScores.length;i++) {
			for(int k = 0; k<javaScores[i].length;k++) {
				System.out.println("javaScores[" + i + "][" + k + "] = " + javaScores[i][k]);
			}
		}

	}

}
