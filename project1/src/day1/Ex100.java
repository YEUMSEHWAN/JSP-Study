package day1;
/* 글자크기 : [Ctrl] + [+/-]
저장 : [Ctrl] + [S]
실행 : [Ctrl] + [F11]
한줄삭제 : [Ctrl] + [D] */


// [정리] 주석 작성하는 방법 : (1) //부터 그 문장 끝까지.
// 					   (2) /* 부터 */ 까지.
public class Ex100 {

	public static void main(String[] args) {
		System.out.println("Hello world"); // 화면출력.
		System.out.println("Hello world, CH!"); // "문자열"
		System.out.println(123);
		System.out.println(3.14);
		
		String s1;  // s1이라는 이름을 선언("변수") --> 문자열을 저장.
		s1 = "Hello ";
		String s2;
		s2 = "world ";
		System.out.println(s1+s2); // 문자열 + 문자열 (이해)
		System.out.println("5 + 3");
		System.out.println("System.out.println(3);");
		
		// 연습 : name을 이용해서 I'm CH라는 식으로 출력.
		String name = "CH";
		System.out.println("I'm " + name);
	}
	

}
