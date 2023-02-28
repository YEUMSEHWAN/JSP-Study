package day2;

public class Ex209_ex {

	public static void main(String[] args) {
		// 1~8까지의 값을 구하시오.
		int i = 3;
		int j = 0;

		j = i++;

		System.out.println("1 : " + i);
		System.out.println("2 : " + j);

		j = i - j;
		System.out.println("3 : " + -i);
		System.out.println("4 : " + (j = -j));

		i++;
		++j;

		System.out.println("5 : " + i++);
		System.out.println("6 : " + ++j);
		System.out.println("7 : " + -i);
		System.out.println("8 : " + -++j);

//----------------------------------------------

		int num1 = 7, num2 = 7;
		int result1, result2;

		result1 = --num1 + 4;
		result2 = num2-- + 4;

		System.out.println("전위 감소 연산자에 의한 결과 : " + result1 + ", 변수의 값 : " + num1);
		System.out.println("후위 감소 연산자에 의한 결과 : " + result2 + ", 변수의 값 : " + num2);

	}

}
