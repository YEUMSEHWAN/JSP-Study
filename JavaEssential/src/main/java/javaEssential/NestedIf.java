package javaEssential;

import java.util.*;

public class NestedIf {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("점수를 입력하세요(0 ~ 100) : ");
		int score = sc.nextInt();// 점수 읽기
		System.out.println("학년을 입력하세요(1~4) : ");
		int year = sc.nextInt();

		if (score >= 60) {
			if (year != 4)
				System.out.println("합격!"); // 4학년이 아니면 합격
			else if (score >= 70)
				System.out.println("합격!");// 4학년이 70점 이상이면 합격
			else
				System.out.println("불합격!");// 4학년이 70점 미만이면 불합격
		} else // 60점 미만이면
			System.out.println("불합격!");

		sc.close();
	}

}
