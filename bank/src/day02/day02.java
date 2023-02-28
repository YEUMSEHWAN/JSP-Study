package day02;

import java.util.*;

public class day02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

//		문제 1

//		가로 7, 세로 6, 높이 12인 사각형의 넓이를 구하시오. 
//		단, 출력하는 값의 변수 타입은 정수, 실수 두가지로 나타내시오.

//-----------------------------------------------------------------------------

//		문제 2

		/*
		 * 반지름의 길이를 스캐너로 이용하여 사용자의 정의대로 받은 후 원의 둘래의 길이를 구하시오. 단, 3.14는 상수값.
		 * 
		 */

//-----------------------------------------------------------------------------

//		문제 3

//		각각의 출력값을 말하시오.
		int a = 3;
		int b = 2;
		int c = 4;

		a += b;
		System.out.println(a);

		a *= c;
		System.out.println(a);

		b /= 1;
		System.out.println(b);

//------------------------------------------------------------------------------

//		문제 4

		int q = 7;
		int w = 11;

		System.out.println(q > w);
		System.out.println(q < w);
		System.out.println(q <= w);
		System.out.println(q >= w);
		System.out.println(q == w);
		System.out.println(q != w);

//------------------------------------------------------------------------------		

//		문제 5

		System.out.println('a' > 'b');
		System.out.println(3 >= 2);
		System.out.println(-1 < 0);
		System.out.println(3.45 >= 2);
		System.out.println(3 == 2);
		System.out.println(3 != 2);
		System.out.println(!(3 >= 2));

		System.out.println((3 > 2) && (3 > 4));
		System.out.println((3 != 2) || (-1 > 0));

//------------------------------------------------------------------------------		

//		문제 6

		int num = 4;
		num++;
		--num;
		System.out.println(num++);
		++num;
		System.out.println(--num);
		int num2 = num++;
		System.out.println(++num2);
		int num3 = ++num;
		System.out.println(num3);
		int num4 = num++;
		System.out.println(++num4);

//------------------------------------------------------------------------------		

//		문제 7

		int i = 10;
		System.out.println("첫번째 : " + (++i * 10));
		System.out.println("두번째 : " + (i-- * 5));
		System.out.println("세번째 : " + (--i * 2));
		System.out.println("네번째 : " + (++i * 4));

//------------------------------------------------------------------------------		

//		문제 8

		int o = 3, p = 5;
		System.out.println("두 수의 차는 " + ((o > p) ? (o - p) : (p - o)));

//------------------------------------------------------------------------------		

//		문제 9
//		 첫번째 변수가 2 또는 7 또는 8 이고 두번째 변수는 3보다 큰지 스캐너를 이용하여 조건식을 만들어 보시오.

//------------------------------------------------------------------------------		

//		문제 10

//		스캐너객체를 이용하여 정수 하나를 입력 받아서 홀,짝 여부를 판별하시오.
//		단, 삼항연산자, if문 두개 만드시오.

//------------------------------------------------------------------------------		

//		문제 11

//		스캐너객체를 이용하여 자신의 "이름" , "나이", "성별", "주거도시" 를 작성하시오.
//		단 출력값은 2개 작성하시오.

//	  출력값 예시1 : 홍길동		  출력값 예시2 : 저는 홍길동이고 나이는 24살 남자이고 사는곳은 서울 입니다. 
//			   	  24								
//			      남 서울								
//------------------------------------------------------------------------------		

//		문제 12 

//		스캐너 객체를 이용하여 정수 2개를 입력 받아 그 수의 합이 음수인지 양수인지 판별하시오.

//------------------------------------------------------------------------------		

//		문제 13

//		for문을 이용하여 1 ~ 40 까지 출력하시오.

//------------------------------------------------------------------------------		

//		문제 14

//		for문을 이용하여 60까지 3의 배수만 출력하시오.

//		출력값 예시 : 60까지의 3의 배수는 : ...
//------------------------------------------------------------------------------		

//		문제 15

//		for문과 if문을 이용하여 70부터 1까지 홀수, 짝수를 나누시오.

//		출력값 예시 : 짝수 : ....
//				   홀수 : ....
//------------------------------------------------------------------------------		

//		문제 16

//		for문과 if문을 이용하여 100부터 1까지 홀수들의 합을 구하시오.

//		출력값 예시 : 홀수의 합은 : ... 

//------------------------------------------------------------------------------		

//		문제 17 
//		for문을 이용하여 1 ~ 100 까지의 합을 출력하시오.

//		출력값 예시 : 1 ~ 100의 합은 : ...

//------------------------------------------------------------------------------	
//		문제 18 (369게임 만들기)
//		1부터100까지 369게임에서 박수를 쳐야하는 경우를 순서대로 화면에 출력하시오.(난위도 상)

		for (int z = 1; z < 100; z++) {
			int count = 0; // 3의 배수 세기

			int first = z / 10; // 10의 자리 수
			int second = z % 10; // 1의 자리 수

			if ((first != 0) && (first % 3 == 0)) {
				count++; // 3의 배수 발견
			}
			if ((second != 0) && (second % 3 == 0)) {
				count++; // 3의 배수 발견
			}

			switch (count) {
			case 1:
				System.out.println(z + " 박수한번");
				break;
			case 2:
				System.out.println(z + " 박수두번");
				break;
			}
		}

//		출력값 예시 : 3 박수한번
//				   6 박수한번
//				   9 박수한번

//------------------------------------------------------------------------------	
//		문제 19 (구구단 만들기)
//		1단부터 9단까지 구구단을 만드시오.(난위도 중)

//		출력값 예시 : 1 * 1 = 1		1 * 2 = 2  ...
//				   2 * 1 = 2	2 * 2 = 4
//				   3 * 1 = 3	3 * 2 = 6
//					.
//					.
//					.

//------------------------------------------------------------------------------	
//		문제 21 (가위바위보게임)

//		철수와 영희가 가위바위보를 한다. 스캐너객체를 이용하여 먼저 "철수"를 출력하고
//		"가위", "바위", "보" 중 하나를 문자열로 입력받는다. 영희에 대해서도 마찬가지 방법으로 입력받는다.
//		두 사람으로 부터 문자열을 입력 받은후 누가 이겼는지 판별하여 승자를 출력하라.(난위도 상)

		System.out.println("가위 바위 보 게임입니다.");
		System.out.print("철수>>");

		String su = sc.next();// 철수의 값을 입력받는다.
		System.out.print("영희>>");
		String young = sc.next();// 영흐의 값을 입력 받는다.

		if (su.equals("가위")) {// 철수가 가위를 낸 경우
			if (young.equals("가위")) {
				System.out.println("비겼습니다.");
			} else if (young.equals("바위")) {
				System.out.println("영희가 이겼습니다.");
			} else {
				System.out.println("철수가 이겼습니다.");
			}
		} else if (su.equals("바위")) {// 철수가 바위를 낸 경우
			if (young.equals("바위")) {
				System.out.println("비겼습니다.");
			} else if (young.equals("가위")) {
				System.out.println("철수가 이겼습니다.");
			} else {
				System.out.println("영희가 이겼습니다.");
			}
		} else {
			if (young.equals("보")) {
				System.out.println("비겼습니다.");
			} else if (young.equals("가위")) {
				System.out.println("영희가 이겼습니다.");
			} else {
				System.out.println("철수가 이겼습니다.");
			}
		}

//		출력값 예시 : 
//			가위 바위 보 게임입니다. 가위 바위 보 중에서 입력해 주세요.
//			철수>>
//			영희>>
//			철수가 이겼습니다.

//------------------------------------------------------------------------------	
	}
}
