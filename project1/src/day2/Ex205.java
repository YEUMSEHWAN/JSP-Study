package day2;

//산술 + 대입 연산자(+=, -=, *=, /=, %=)
public class Ex205 {
	public static void main(String[] args) {
		int a = 3;
		int b = 2;
		a += b; // a = a + b; 라는 의미.
		System.out.println(a); // 5
		
		a *= b; //a = 5, b = 2;
		System.out.println(a);//10
		
		b /= 10; // b = b / 10;
		System.out.println(b); // 0
		
	}
}
