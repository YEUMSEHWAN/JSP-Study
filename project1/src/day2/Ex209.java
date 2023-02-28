package day2;

//증감연산자 (++, --)
public class Ex209 {
	public static void main(String[] args) {
		int num = 5;
		num++;
		System.out.println(num);// 6
		++num;
		System.out.println(num);// 7

		int num2 = num++;
		// - int num2 = num; //7
		// - num++ //8
		System.out.println(num2);// 7
		int num3 = ++num;
		// - num++
		// - int num3 = num;
		System.out.println(num3);// 9

		int num4 = num--;
		System.out.println(--num4);// 8

		int i = 10;
		System.out.println("첫번째 : " + (++i * 10));
		System.out.println("두번째 : " + (i-- * 5));
		System.out.println("세번째 : " + (--i * 2));
		System.out.println("네번째 : " + (++i * 4));
		// 110
		// 55
		// 18
		// 40
	}
}
