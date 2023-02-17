package javaEssential;

import java.util.*;

public class ArithemticOperatior {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수를 입력해 주세요 : ");

		int time = sc.nextInt(); // 정수 입력
		int second = time % 60; // 60 으로 나눈 나머지는 초
		int minute = (time / 60) % 60; // 60으로 나눈 몫을 다시 60으로 나눈 나머지는 분
		int hour = (time / 60) / 60; // 60으로 나눈 몫을 다시 60으로 나눈 몫은 시간

		System.out.println(time + "초는 ");
		System.out.println(hour + "시간, ");
		System.out.println(minute + "분, ");
		System.out.println(second + "초 입니다. ");

		sc.close();// Scanner 의 사용 종료..//응용프로그램에서 Scanner를 닫는 코드가 없으면 컴파일 시에 경고(Warning)가 발생..
	}

}
