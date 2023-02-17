package javaEssential;

public class TernaryOperator {

	public static void main(String[] args) {
		int a = 3, b = 5;

		// 만약 condition의 값이 true면 전체 식의 값은 a-b, false라면 b-a
		System.out.println("두 수의 차는 " + ((a > b) ? (a - b) : (b - a)));

	}

}
