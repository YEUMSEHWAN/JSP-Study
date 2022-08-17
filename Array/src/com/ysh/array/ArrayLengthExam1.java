package com.ysh.array;

public class ArrayLengthExam1 {

	public static void main(String[] args) {
		int[] scores = {87,89,90};
		int sum = 0;
		for(int i=0;i<3;i++) {
			sum += scores[i];
		}
		System.out.println("총점 : " + sum);
		
		//length필드는 읽기전용 필드이기 때문에 값을 바꿀수없다.
		//배열변수.length
		double avg = (double) sum/scores.length;
		System.out.println("평균 : " + avg);
		
		
		
		
	}

}
