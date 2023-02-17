package javaEssential;

import java.util.Scanner;

public class Twenties {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.printf("나이를 입력하시오 : ");
		int age = sc.nextInt();// 정수 입력 받기
		if ((age >= 20) && (age < 30)) {
			System.out.println("あなたは20代です。");
			System.out.println("20대라서 행복합니다~");
		} else {
			System.out.println("20대가 아닙니다.");
		}
		sc.close();
	}

}
