package com.ysh.array;

/*
 * 매개변수로 int[] 배열이 선언된 add()메소드가 있을 경우, 값 목록으로 배열을 생성함과 동시에
 * add()메소드의 매개값으로 사용하고자 할때는 반드시 new연산자를 사용해야 한다.
 * 
 * 
 */
public class ArrayCreateExample2 {

	public static void main(String[] args) {

		int[] scores;
		scores = new int[] { 83, 88, 90 };

		int sum1 = 0;
		for (int i = 0; i < 3; i++) {
			sum1 += scores[i];
		}
		System.out.println("총합 : " + sum1);

		int sum2 = add(new int[] { 83, 88, 90 });// 리턴된 총 합을 sum2에 저장
		System.out.println("총합 : " + sum2);
		System.out.println();

	}
	public static int add(int[]scores) {
		int sum = 0;
		for(int i = 0;i<3;i++) {
			sum += scores[i];
		}
		return sum;
	}

}
