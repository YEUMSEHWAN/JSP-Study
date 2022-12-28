package javaEssential;

public class Hello {

	public static int sum(int n, int m) { // sum 이라는 함수 설정.

		return n + m;// void가 아니므로 return 값 설정해줘야함.

	}

	// main() 메소드에서 시작
	public static void main(String[] args) {

		int b;
		int i = 20;
		int s;
		char a;
		//또는 int sum = i + 10; 

		s = sum(i, 10); // 메소드 호출
		b = sum(i,30);
		a = '?';
		System.out.println(a); // 문자 '?' 출력 (char)문자타입 하나.
		System.out.println("Hello"); // "Hello" 문자열 출력(String)
		System.out.println(s); // 정수 s의 값 30출력 sum(i ,10)
		System.out.println(b);

	}
	
	//식별자 이름 규칙.
	
	int name; // 식별자의 첫 번째 문자로 숫자는 사용 불가능.
	char student_$ID;//'_' 또는 '$' 사용 가능(다른 특수문자는 불가능), 자바의 예약어(if) 사용 불가.
	void _$func() {} // '_' 또는 '$' 사용 가능(다른 특수문자는 불가능), false 사용 불가.
	class Monster3{} // 숫자 사용 가능, null 사용 불가.
	int WhatsYourNameMyNameIsHwan; // 문자의 길이 제한이 없음.
	int barChart; int barchart; //자바는 대소문자 구분. barchart 와 barChart는 다른 이름.
	int 가격;//한글 사용 가능.
	
	/* 자바의 기본 타입(basic type) 8개
	 * boolean 논리타입 (1비트, true or false)
	 * char 문자타입 (2바이트, Unicode)
	 * byte 정수타입 (1바이트, -128 ~ 127)
	 * short 정수타입 (2바이트, -32768 ~ 32767)
	 * int 정수타입 (4바이트, -2^31 ~ 2^31-1)
	 * long 정수타입 (8바이트, -2^63 ~ 2^63-1)
	 * float 실수타입 (4바이트)
	 * double 실수타입 (8바이트)
	 */
	
	//***유니코드 : 유니코드는 전세계의 모든 문자를 표현하기 위해, 문자당 2바이트의 산업 표준 코드 체계로 유니코드 협회가 제정한다.
	//			 유니코드에는 ISO10640 문자집합, 문자인코딩, 문자 정보 데이터베이스, 문자를 처리하기 위한 알고리즘 등이 포함되어 있다.
	
	
	//-----------------------------------------------------------
	// 문자열
	String toolName = "JDK";
	
	

}
