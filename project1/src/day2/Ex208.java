package day2;

import java.util.Scanner;//import 문

//스캐너 입력 받기
public class Ex208 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		int b;
		a = sc.nextInt();
		b = sc.nextInt();
		System.out.println(a);
		System.out.println(b);
// 정수 값을 입력 --->
// 스캐너 객체 생성 문장 : Scanner sc = new Scanner(System.in);
		System.out.print("정수 값 입력 : ");
		int num = sc.nextInt();
		System.out.println("입력 받은 값 : " + num);
		
		int j = 5;
		int k = 50;
		int hh = j/k*100;
		System.out.println(hh);
	}
}
