package day2; //"패키지 선언" : 반드시 첫줄에.

/*
 * 1) 정수형 값을 저장할 변수 a를 선언하고 33으로 초기화.
 * 2) 실수형 값을 저장할 변수 b를 선언하고 3.14로 초기화.
 * 3) 한 문자를 저장한 변수 c를 선언하고 '가'로 초기화.
 * 4) 두 변수 x,y를 사용해서 아래와 같은 코드를 이용,
 * 	  5+3을 계산하려고 합니다. 빈 칸 채우세요.
 * _______ = _____;
 * int y = 3;
 * sysout(x+y);
 * 
 * 5) x2가 5이고 y2가 3일때 --두 변수를 선언하고 초기화--
 * 이 두 변수의 합을 변수 z에 저장한 후, z를 출력
 * 6) 3.14를 PI라는 이름의 상수에 담고, 10을 r이라는 이름의 변수에 담은 후,
 * 원의 넓이 (PI * r * r )를 변수 area에 담은후 area를 출력.
 */
public class Ex201 {

	public static void main(String[] args) {
		// 1) 정수형 값을 저장할 변수 a를 선언하고 33으로 초기화.
		int a;
		a = 33;
		// 2) 실수형 값을 저장할 변수 b를 선언하고 3.14로 초기화.
		double b;
		b = 3.14;
		// 3) 한 문자를 저장한 변수 c를 선언하고 '가'로 초기화.
		char c;
		c = '가';
		// 4) 두 변수 x,y를 사용해서 아래와 같은 코드를 이용,
		// 5+3을 계산하려고 합니다. 빈 칸 채우세요.
		int x = 5;
		int y = 3;
		System.out.println(x + y);
		// 5) x2가 5이고 y2가 3일때 --두 변수를 선언하고 초기화--
		// 이 두 변수의 합을 변수 z에 저장한 후, z를 출력
		int x2 = 5;
		int y2 = 3;
		int z = x2 + y2;
		System.out.println(z);

		//6) 3.14를 PI라는 이름의 상수에 담고, 10을 r이라는 이름의 변수에 담은 후,
		//원의 넓이 (PI * r * r )를 변수 area에 담은후 area를 출력.
		final double PI = 3.14;
		int r = 10;
		double area = PI * r * r;
		System.out.println(area);
		
		System.out.println("a : ");
		System.out.println(4*5);
		
		

	}

}
