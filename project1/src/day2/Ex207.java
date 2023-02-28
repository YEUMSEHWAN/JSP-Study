package day2;

public class Ex207 {
	public static void main(String[] args) {
//		%% (shift + 7) 앰퍼샌드! ---> AND
//		|| (Shift + 역슬래시) 파이프! ---> OR
//		[정리] AND : 둘 다 true 여야 true 
//			  OR  : 둘 중 하나만 true 여도 true

		int a = 5;
		// 1) a가 5 이거나 6이냐? ---> true
		System.out.println(a == 5 || a == 6);
		// System.out.println(a == 5 || 6); // err.
		System.out.println(a == 5 || a == 6 || a == 7);

		int num = 37;
		// 십의자리
		System.out.println(num / 10);
		// 일의자리
		System.out.println(num % 10);

		// ------------문제-------------------
		// 비교연산
		System.out.println('a' > 'b');
		System.out.println(3 >= 2);
		System.out.println(-1 < 0);
		System.out.println(3.45 >= 2);
		System.out.println(3 == 2);
		System.out.println(3 != 2);
		System.out.println(!(3 >= 2));

		// 비교연산과 논리 연산 복합
		System.out.println((3 > 2) && (3 > 4));
		System.out.println((3 != 2) || (-1 > 0));
		System.out.println((3 != 2) ^ (-1 > 0));

	}
}
