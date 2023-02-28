package javaEssential;

public class DoWhileSample {

	public static void main(String[] args) {
		char a = 'a';

		do {
			System.out.print(a);// 문자 출력
			a = (char) (a + 1);
		} while (a <= 'z');
	}
}
