package javaEssential;

import java.util.*;

public class ScannerEx2 {

	public static void main(String[] args) {
		System.out.println("이름, 도시, 나이, 체중, 독신 여부를 빈칸으로 분리하여 입력하세요.");

		Scanner sc = new Scanner(System.in);
		String name = sc.next();// 문자열 토큰 읽기
		System.out.println("당신의 이름은 " + name + "입니다.");

		String city = sc.next();// 문자열 토큰 읽기

		System.out.println("당신이 사는 도시는 " + city + "입니다.");

		int age = sc.nextInt();// 정수 토큰 읽기
		System.out.println("당신의 나이는 " + age + "입니다.");

		double weight = sc.nextDouble();// 실수 토큰 읽기
		System.out.println("당신의 몸무게는 " + weight + "입니다.");

		boolean single = sc.nextBoolean();// 논리 토큰 읽기
		System.out.println("당신의 독신여부는 " + single + "입니다.");

		sc.close();

	}

}
