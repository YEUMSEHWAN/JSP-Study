package day2;

import java.util.*;

public class Ex211 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 조건식 연습
//		-”a가 1 또는 4 또는 7 이고 b는 0보다 크냐?"
//		int a, b;
//		a = sc.nextInt();
//		b = sc.nextInt();
//
//		System.out.println(a == 1 || a == 4 || a == 7 ? "true" : "false");
//		System.out.println(b > 0 ? "true" : "false");
//		System.out.println((a == 1 || a == 4 || a == 7) && (b > 0) ? "true" : "false");

		// 스캐너 객체 생성 문장 : Scanner sc = new Scanner(System.in);
		int num;
		num = sc.nextInt();
//		if (num % 2 == 0) {
//			System.out.println("짝수입니다.");
//		} else {
//			System.out.println("홀수입니다.");
//		}
//		System.out.println(num % 2 == 0 ? "짝수" : "홀수");

		// 정수 하나를 입력받아 양수인지 음수인지 또는 영인지 판별하시오.
		if (num > 0) {
			System.out.println("양수입니다.");
		} else if (num < 0) {
			System.out.println("음수 입니다.");
		} else {
			System.out.println("0입니다.");
		}

		int num1 = 5;
		if (num > 0) {
			System.out.println();
		}
		System.out.println();// if문과 상관없이 출력.

	}
}
