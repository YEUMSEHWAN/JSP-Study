package day1;
// 정수 (ex. 5) -----> "int" 라고 생각
// 실수 (ex. 5.15) --> "double" 이라고 생각
// 문자열 : 문자들의 나열 --> 따옴표(")를 사용 --> "String"
// 문자 --------------> 홑따옴표(')를 사용 -> "char"

public class Ex102 {
	public static void main(String[] args) {
		int n = 5; // (표현 이해) "변수의 선언과 동시에 초기화"
		System.out.println("n : " + n);
		double n2 = 5.15; // 5로 고쳐도 에러 없음 
		System.out.println("n2 : " + n2);
		
		
		String s = "ABC"; // 문자열
		System.out.println("문자열 s : " + s);
		char c = 'A';  // 문자
		System.out.println("문자 c : " + c);
		
	}

}
