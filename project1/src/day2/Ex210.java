package day2;

//삼항 연산자('항'이 3개인 연산자)
public class Ex210 {
	public static void main(String[] args) {
		int num = 5;
		System.out.println(num % 2 == 0 ? "짝수" : "홀수");

		char ch = (num % 2 == 0 ? '짝' : '홀');
		// char은 문자 하나이기 때문에 싱글쿼터
		System.out.println(ch + "수");

		// -------문제------------------------------
		int a = 3, b = 5;
		System.out.println("두 수의 차는 " + ((a > b) ? (a - b) : (b - a)));
	}
}
